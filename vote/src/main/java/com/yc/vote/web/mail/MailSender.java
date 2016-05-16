package com.yc.vote.web.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	public void SendMail(String email,String username) {
		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);//邮件信息类
			smm.setFrom("studymail_test@163.com");//邮件发送者与spring中的username是服务器账号
			smm.setTo(email);//邮件接收者
			smm.setSubject("账户激活");//邮件主题
			smm.setText("Hi,"+username+"：欢迎注册<br/>"
					+"<a href='http://www.baidu.com'>去百度玩吗？？</a><br/>"
					+"<img src='cid:pic123'/>",true);//邮件内容
			FileSystemResource fsr=new FileSystemResource("d:/02.jpg");
			smm.addInline("pic123", fsr);
			FileSystemResource file = new FileSystemResource(new File("d:/7.jpg"));
			smm.addAttachment("CoolImage.jpg", file);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mm);//发送邮件
		System.out.println("邮件发送成功");
	}
}
