package vmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vmall.po.Cart;
import vmall.po.User;
import vmall.pojo.MyCart;
import vmall.service.CartService;

@Controller("cartController")
@RequestMapping("/cart")
public class CartController extends BaseController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addCart")
	public String addCart(String pid,Integer buyNum,HttpSession session) {
		User user=(User)session.getAttribute("user");
		System.out.println("here"+user.getUid());
		Cart cart=new Cart(user.getUid(),pid,buyNum);
//		System.out.println(cart);
		Cart _cart=cartService.findCart(cart);
		if(_cart== null) {
			cartService.addCart(cart);
		}else {
			cartService.updateCart(_cart);
		}
		return "forward:/cart/showcart";
	}
	
	@RequestMapping("/showcart")
	public String showcart(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		List<MyCart> carts=cartService.showcart(user.getUid());
		model.addAttribute("carts",carts);
		return "cart";
	}
	
	@RequestMapping("/updateBuyNum")
	public void updateBuyNum(Integer cartID,Integer buyNum) {
		Cart newcart =new Cart();
		newcart.setCartID(cartID);
		newcart.setNum(buyNum);
		cartService.updateBuyNum(newcart);
	}
	
	@RequestMapping("/delCart")
	public void delCart(Integer cartID) {
		cartService.delCart(cartID);
	}
	
}




