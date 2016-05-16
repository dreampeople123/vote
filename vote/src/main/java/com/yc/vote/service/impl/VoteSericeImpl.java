package com.yc.vote.service.impl;

import java.util.List;






import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.User;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.mapper.SubjectMapper;
import com.yc.vote.mapper.UserMapper;
import com.yc.vote.service.VoteService;
//@Transactional
@Service("voteService")
public class VoteSericeImpl implements VoteService {
	@Autowired
	private SubjectMapper subjectMapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<Subject> findAllSubjects() {
		return subjectMapper.getAllSubjects();
	}
	@Override
	public User Login(User user) {
		User ser= userMapper.Login(user);
			return ser;
	}
	@Override
	public User Register(User user) {
		int  result=userMapper.Register(user);
		//	MyBatisUtil.Close(session);
			if(result==1){
				return user;
			}else {
				return null;
			}
	}
	@Override
	public List<SubjectBean> findAllSubjectBeans() {
		return subjectMapper.getAllSubjectBeans();
	}
	@Override
	public OptionBean findOptionsById(int vsId) {
		return subjectMapper.getOptionsByVsId(vsId);
	}
	@Override
	public VoteBean findVoteBeanByVsId(int vsId) {
		return subjectMapper.getVoteBeanByVsId(vsId);
	}
	@Override @Transactional(propagation=Propagation.REQUIRED)
	public boolean saveVote(Item item) {
	
			try {
				if(item.getVoId()!=0){
					subjectMapper.insertItem(item);
					return true;
				}
				return false;
			} catch (Exception e) {
				LogManager.getLogger().debug("添加Item失败",e);
				throw new RuntimeException("添加Item失败",e);
			}
		
	}
	@Override @Transactional(propagation=Propagation.REQUIRED)
	public boolean saveVote(Item item, String[] voId) {
		if(voId!=null&&voId.length>1){
			for(String v:voId){
				item.setVoId(Integer.parseInt(v));
				if(!saveVote(item)){
					return false;
				}
			}
			return true;
		}
		return saveVote(item);
	}
	
	
}
