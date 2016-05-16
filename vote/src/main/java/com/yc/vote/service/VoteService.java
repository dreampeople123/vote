package com.yc.vote.service;

import java.util.List;

import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.User;
import com.yc.vote.entity.VoteBean;

public interface VoteService {
	public List<Subject> findAllSubjects();
	public List<SubjectBean> findAllSubjectBeans();
	public OptionBean findOptionsById(int vsId);

	public User Login(User user);

	public User Register(User user);
	public VoteBean findVoteBeanByVsId(int vsId);
	public boolean saveVote(Item item);
	public boolean saveVote(Item item, String[] voId);
}
