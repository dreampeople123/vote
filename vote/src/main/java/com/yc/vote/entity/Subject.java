package com.yc.vote.entity;

import java.util.List;

import org.springframework.stereotype.Component;

public class Subject {
    private Long vsId;

    private String vsTitle;

    private Integer vsType;
    
    private List<Option> options;
	private int opno;//选项数量
	private int itno;//网友参与数量

	public Long getVsId() {
		return vsId;
	}

	public void setVsId(Long vsId) {
		this.vsId = vsId;
	}

	public String getVsTitle() {
		return vsTitle;
	}

	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}

	public Integer getVsType() {
		return vsType;
	}

	public void setVsType(Integer vsType) {
		this.vsType = vsType;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public int getOpno() {
		return opno;
	}

	public void setOpno(int opno) {
		this.opno = opno;
	}

	public int getItno() {
		return itno;
	}

	public void setItno(int itno) {
		this.itno = itno;
	}

	@Override
	public String toString() {
		return "\nSubject [vsId=" + vsId + ", vsTitle=" + vsTitle + ", vsType="
				+ vsType + "]";
	}

   
}