package com.yc.vote.web.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.User;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.MoreVoteService;
import com.yc.vote.service.VoteService;

@Controller("voteAction")
public class VoteAction implements SessionAware ,ModelDriven<Item>{
	@Autowired
	private VoteService voteService;
	@Autowired
	private MoreVoteService moreVoteService;
	private Item item;
	private Map<String,Object> session;

	public String list(){
		allVote();
		return "list";
	}
	public String view(){
		LogManager.getLogger().debug("日志"+item.getVsId());
		OptionBean optionBean=(OptionBean) voteService.findOptionsById(item.getVsId());
		session.put("optionBean",optionBean);
		return  "view";
	}

	public String vote(){
		LogManager.getLogger().debug("日志"+item.getVsId());
		VoteBean voteBean=voteService.findVoteBeanByVsId(item.getVsId());
		session.put("voteBean",voteBean);
		return  "vote";
	}
	public String save(){
		String[] voId=ServletActionContext.getRequest().getParameterValues("voId");
		LogManager.getLogger().debug("item "+item+Arrays.toString(voId));
		try {
			if(voteService.saveVote( item,voId)){
				return  "voteSuccess";
			}
			session.put("errorMsg", "投票失败。。。。");
			return "voteFail";
		} catch (Exception e) {
		}
		session.put("errorMsg", "投票失败。。。。");
		return "voteFail";

	}


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
	public Item getModel() {
		item=new Item();
		return item;
	}

}
