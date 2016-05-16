package com.yc.test;

import static org.junit.Assert.*;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JavaMailSenderTest {
	@Autowired
	private JavaMailSender javaMailSender;
	@Test
	public void testSendMail() {
		SimpleMailMessage smm=new SimpleMailMessage();//邮件信息类
		smm.setFrom("DreamForReal@163.com");//邮件发送者与spring中的username是服务器账号
		smm.setTo("1107577214@qq.com");//邮件接收者
		smm.setSubject("邮件整合测试");//邮件主题
		smm.setText("Hi,spring邮件发送好suuusdf2");//邮件内容
		javaMailSender.send(smm);//发送邮件
		System.out.println("邮件发送成功");
	}
	@Test
	public void testSendMail02() {
		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);//邮件信息类
			smm.setFrom("studymail_test@163.com");//邮件发送者与spring中的username是服务器账号
			smm.setTo("1107577214@qq.com");//邮件接收者
			smm.setSubject("邮件整合测试");//邮件主题
			smm.setText("Hi,spring邮件发喜欢3<br/>"
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
