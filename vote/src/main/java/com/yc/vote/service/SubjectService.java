package com.yc.vote.service;

import java.util.List;

import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.entity.Option;
import com.yc.vote.entity.Subject;

public interface SubjectService {
	public AddSubjectBean addSubject(AddSubjectBean addSubjectBean);
	public void addOption(Option option);
	public void add(AddSubjectBean addSubjectBean);

}
