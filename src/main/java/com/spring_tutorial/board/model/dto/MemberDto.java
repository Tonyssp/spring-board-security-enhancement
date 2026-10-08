package com.spring_tutorial.board.model.dto;

import java.sql.Date;

public class MemberDto {
	private String userId;
	private String userPw;
	private String userName;
	private Date regDate;
	private String confirmPw;

	// Add field: login attempt count and account lock status
	private int loginAttempts;
	private boolean accountLocked;

	@Override
	public String toString() {
		return "MemberDto{" +
				"userId='" + userId + '\'' +
				", userPw='" + userPw + '\'' +
				", userName='" + userName + '\'' +
				", regDate=" + regDate +
				", confirmPw='" + confirmPw + '\'' +
				", loginAttempts=" + loginAttempts +
				", accountLocked=" + accountLocked +
				'}';
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getConfirmPw() {
		return confirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

	public MemberDto() {}

	public MemberDto(String userId, String userPw, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.loginAttempts = 0; // initialization attempt to count
		this.accountLocked = false; // Initialize account lock status
	}

	// Getters and Setters
	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

}

