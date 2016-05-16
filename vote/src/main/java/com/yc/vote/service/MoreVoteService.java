package com.yc.vote.service;

import com.yc.vote.entity.Item;

public interface MoreVoteService {
	public boolean saveVote(Item item, String[] voId);
}
