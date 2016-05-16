package com.yc.vote.web.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vate.util.VoteData;
import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.User;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.SubjectService;
import com.yc.vote.service.VoteService;

@Controller("subjectAction")
public class SubjectAction implements ModelDriven<AddSubjectBean> {
	private AddSubjectBean addSubjectBean;
	@Autowired
	private SubjectService subjectService;
	
	public String save(){
		LogManager.getLogger().debug("aua进来了"+addSubjectBean);
		try {
			subjectService.add(addSubjectBean);
			return "AddSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "AddFail";
	}

	@Override
	public AddSubjectBean getModel() {
		addSubjectBean=new AddSubjectBean();
		return addSubjectBean;
	}

}
