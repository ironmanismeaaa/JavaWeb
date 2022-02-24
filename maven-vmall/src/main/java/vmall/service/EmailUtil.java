package vmall.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	private static String fromEmail = "1634377417@qq.com";  // 发件人账�?
	private static String fromEmailPw = "emvamylapsnzeffa";  // 发件人密�?
	private static String myEmailSMTPHost = "smtp.qq.com";  // 发件邮箱服务�?
	private static Properties props;  // 用于参数配置
	private static Session session;  // 用于创建会话对象
	private String vCode;
	public static EmailUtil instance = new EmailUtil();
	
	/*
	 * 获取验证�?
	 * @return 验证码字符串
	 */
	public String getVCode() {
		return vCode;
	}
	
	/*
	 * 构�?�函数，配置属�??
	 */
	private EmailUtil() {
		props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");  // 使用的协议（JavaMail规范要求�?
        props.setProperty("mail.smtp.host", myEmailSMTPHost);  // 发件人的邮箱�? SMTP 服务器地�?
        props.setProperty("mail.smtp.auth", "true");  // �?要请求认�?
        session = Session.getInstance(props);
        // session.setDebug(true);  // 设置为debug模式, 可以查看详细的发�? log 
	}
	
	/*
	 * 构建邮件内容
	 * @param 收件�?
	 * @return 发�?�邮件内�?
	 */
	public MimeMessage createMailContent(String toEmail) throws Exception, MessagingException {
		MimeMessage message = new MimeMessage(session);
		// 发件�?
		message.setFrom(new InternetAddress(fromEmail, "验证码发送系�?", "UTF-8"));
		// 收件�?
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
		// 邮件主题
		message.setSubject("验证�?", "UTF-8");
		// 邮件正文 
		vCode = VCodeUtill.verifyCode(6);
		message.setContent("您好，您的验证码是："+vCode+"�?", "text/html;charset=UTF-8");
		// 设置发件时间
		message.setSentDate(new Date());
		// 保存设置
		message.saveChanges();
		return message;
	}
	/*
	 * 发�?�邮�?
	 * @param 收件�?
	 */
	public void sendEmail(String toEmail) throws Exception {
		Transport transport = session.getTransport();
		transport.connect(fromEmail, fromEmailPw);
		MimeMessage message = createMailContent(toEmail);  // 邮件内容
		transport.sendMessage(message, message.getAllRecipients());
		System.out.println("验证码发送成功！");
		// 关闭连接
		transport.close();
	}
	public static void main(String[] args) {
		try {
			instance.sendEmail("2879414347@qq.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
