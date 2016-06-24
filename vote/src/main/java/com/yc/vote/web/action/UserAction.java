package com.yc.vote.web.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vate.util.VoteData;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.User;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.VoteService;
import com.yc.vote.web.mail.MailSender;

@Controller("userAction")
public class UserAction implements SessionAware,ModelDriven<User>{
	@Autowired
	private VoteService voteService;
	@Autowired
	private User user;
	@Autowired
	private MailSender mailSender;

	private Map<String,Object> session;
	
	//激活账号
	public String  jihuo(){
		User  jiuser=(User) session.get(VoteData.LOGIN_USER);
		System.out.println("激活"+jiuser);
		int res=mailSender.SendMail(jiuser.getVuEmail(), jiuser.getVuUsername());
		System.out.println("结果"+res);
		if(res>0){
			return "list";
		}else {
			session.put(VoteData.ERROR_MSG,"激活失败！！！");
			return "registerSuccess";
		}
	}
	
	//登陆
	public String login(){
		System.out.println("user   "+user);
		User  result=voteService.Login(user);
		if(result!=null){
			session.put(VoteData.LOGIN_USER,result);
			allVote();
			return "list";
		}else{
			session.put(VoteData.ERROR_MSG,"用户名或密码错误！！");
			return "login";
		}
	}
	//用户注册操作 
	public String register(){
		System.out.println("注册的用户："+user);
		User users=voteService.Register(user);
		if(users!=null){
			session.put(VoteData.LOGIN_USER,users);
			allVote();
			return "registerSuccess";
		}else {
			session.put(VoteData.ERROR_MSG,"注册失败！！！");
			return "register" ;
		}}
	private void allVote() {
		List<SubjectBean> subjects=voteService.findAllSubjectBeans();
		LogManager.getLogger().debug("list请求成功。。。");
		session.put("subjects", subjects);
		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	@Override
	public User getModel() {
		return user;
	}

}
