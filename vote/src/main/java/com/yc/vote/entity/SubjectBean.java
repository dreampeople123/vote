package com.yc.vote.entity;

import java.io.Serializable;

public class SubjectBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8478973879686814147L;

private int vsId;
private  String vsTitle;
private int optionCount;
private int voteUserCount;
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
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "\nSubjectBean [vsId=" + vsId + ", vsTitle=" + vsTitle
			+ ", optionCount=" + optionCount + ", voteUserCount="
			+ voteUserCount + "]";
}

}
