package com.yc.vote.entity;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
    private Long vuId;

    private String vuUsername;

    private String vuPassword;

    private Integer vuStatus;

    private Long vuVersion;
    private String vuEmail;
    

	public String getVuEmail() {
		return vuEmail;
	}

	public void setVuEmail(String vuEmail) {
		this.vuEmail = vuEmail;
	}

	public Long getVuId() {
		return vuId;
	}

	public void setVuId(Long vuId) {
		this.vuId = vuId;
	}

	public String getVuUsername() {
		return vuUsername;
	}

	public void setVuUsername(String vuUsername) {
		this.vuUsername = vuUsername;
	}

	public String getVuPassword() {
		return vuPassword;
	}

	public void setVuPassword(String vuPassword) {
		this.vuPassword = vuPassword;
	}

	public Integer getVuStatus() {
		return vuStatus;
	}

	public void setVuStatus(Integer vuStatus) {
		this.vuStatus = vuStatus;
	}

	public Long getVuVersion() {
		return vuVersion;
	}

	public void setVuVersion(Long vuVersion) {
		this.vuVersion = vuVersion;
	}

	@Override
	public String toString() {
		return "User [vuId=" + vuId + ", vuUsername=" + vuUsername
				+ ", vuPassword=" + vuPassword + ", vuStatus=" + vuStatus
				+ ", vuVersion=" + vuVersion + ", vuEmail=" + vuEmail + "]";
	}



    
}