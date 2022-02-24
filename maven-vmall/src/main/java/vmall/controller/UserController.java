package vmall.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vmall.po.User;
import vmall.service.EmailUtil;
import vmall.service.UserService;

@Controller("userController")
public class UserController {
	private String code="";
	@Autowired
	private UserService userService;	
	@RequestMapping("/user/login")
	public String login(User user,HttpSession session,Model model){
		User user1 = userService.login(user.getUname());
		if(user1 == null){
			model.addAttribute("messageError","�û����������~");
			return "login";
		}else if (user1.getUpwd().equals(user.getUpwd())){
			session.setAttribute("user", user1);
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("messageError", "�������");
			return "login";
		}
	}
	@RequestMapping("/user/checkUser")
	public void checkUsername(String username,HttpServletResponse response) throws IOException{
		if(userService.login(username) != null){
			response.getWriter().print("������û����ѱ�ע��");
		}
		else{
			response.getWriter().print("�û�����ʹ��");
		}
		
	}
	@RequestMapping("/user/regist")
	public String regist(User user,String valistr,HttpSession session,Model model){
		if(userService.login(user.getUname())!=null) {
			model.addAttribute("msg","�û����ѱ�ע��");
			return "regist";
		}
		if(user.getUname()==null||user.getUname()=="")
		{
			model.addAttribute("msg","�û�������Ϊ��");
			return "regist";
		}
		if(user.getUpwd()==null||user.getUpwd()=="")
		{
			model.addAttribute("msg","���벻��Ϊ��");
			return "regist";
		}
		if(!valistr.equalsIgnoreCase(code)){
			model.addAttribute("msg","��֤�����");
			return "regist";
		}
		if(userService.regist(user)>0)
		{
			session.setAttribute("user", user);
			model.addAttribute("msg","ע��ɹ�");
			return "login";
		}
		else{
			model.addAttribute("msg","ע��ʧ��");
			return "regist";
		}
	}
	@RequestMapping("/user/sendcode")
	public void sendcode(String email,HttpServletResponse response) throws IOException{
		System.out.println(email);
		EmailUtil eu=EmailUtil.instance;
		try {
			eu.sendEmail(email);
			code=eu.getVCode();
//			System.out.println(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print("��֤�뷢�ͳɹ�������գ�");
	}
}
