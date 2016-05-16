package com.yc.vote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.vote.entity.Item;
import com.yc.vote.service.MoreVoteService;
import com.yc.vote.service.VoteService;
@Service("moreVoteService")
public class MoreVoteServiceImpl implements  MoreVoteService{
	@Autowired
	private VoteService voteservice;
	@Override@Transactional(propagation=Propagation.REQUIRED)
	public boolean saveVote(Item item, String[] voId) {
		if(voId!=null&&voId.length>1){
			for(String v:voId){
				item.setVoId(Integer.parseInt(v));
				if(!voteservice.saveVote(item)){
					return false;
				}
			}
			return true;
		}
		return voteservice.saveVote(item);
	}


}
