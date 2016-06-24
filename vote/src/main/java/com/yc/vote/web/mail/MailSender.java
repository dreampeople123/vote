package com.yc.vote.web.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service("mailSender")
public class MailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	public int SendMail(String email,String username) {
		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);//邮件信息类
			smm.setFrom("DreamForReal@163.com");//邮件发送者与spring中的username是服务器账号
			smm.setTo(email);//邮件接收者
			smm.setSubject("账户激活");//邮件主题
			smm.setText("Hi,"+username+"：欢迎注册<br/>"
					+"<a href='http://127.0.0.1:8080/vote/vote_list.action'>投票系统</a><br/>");//邮件内容
		} catch (MessagingException e) {
			return 0;
		}
		javaMailSender.send(mm);//发送邮件
		System.out.println("邮件发送成功");
		return 1;
	}
}
