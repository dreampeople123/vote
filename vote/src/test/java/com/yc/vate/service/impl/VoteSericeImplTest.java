package com.yc.vate.service.impl;

import static org.junit.Assert.*;

import java.util.List;






import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.vote.entity.Subject;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.VoteService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class VoteSericeImplTest {
	@Autowired
	private VoteService voteService;
	@Test
	public void testFindAllSubjects() {
		List<Subject> subjects=voteService.findAllSubjects();
		LogManager.getLogger().debug("日志四+"+subjects);
		assertNotNull(subjects);
	}
	@Test
	public void testFindVoteBeanByVsId() {
		VoteBean voteBean=voteService.findVoteBeanByVsId(103);
		LogManager.getLogger().debug("日志四+"+voteBean);
		assertNotNull(voteBean);
	}

}
