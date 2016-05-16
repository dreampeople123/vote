package com.yc.vote.entity;

import java.util.List;

public class VoteBean {
	private String vsTitle;
	private int vsId;
	private int vsType;
	private int optionCount;
	private int voteUserCount;
	private List<Option> options;
	
	public int getVsId() {
		return vsId;
	}
	public void setVsId(int vsId) {
		this.vsId = vsId;
	}
	public String getVsTitle() {
		return vsTitle;
	}
	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}
	public int getVsType() {
		return vsType;
	}
	public void setVsType(int vsType) {
		this.vsType = vsType;
	}
	public int getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
	public int getVoteUserCount() {
		return voteUserCount;
	}
	public void setVoteUserCount(int voteUserCount) {
		this.voteUserCount = voteUserCount;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "VoteBean [vsTitle=" + vsTitle + ", vsId=" + vsId + ", vsType="
				+ vsType + ", optionCount=" + optionCount + ", voteUserCount="
				+ voteUserCount + ", options=" + options + "]";
	}


}
