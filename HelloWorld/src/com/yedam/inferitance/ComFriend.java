package com.yedam.inferitance;
/*
 *  Friend 상속하는 ComFriend.
 *  회사명, 부서정보.//
 */ 
public class ComFriend extends Friend {
	// 필드.
	private String companyName;
	private String department;
	// 생성자.
	public ComFriend(String friendName, String phoneNumber,
			String companyName, String department) {
		super(friendName, phoneNumber);  // super 부모.
		this.companyName = companyName;
		this.department = department;
	}
	
	// showInfo(재정의) -> 회사정보추가.
		@Override
		public String showInfo() {
			return super.showInfo() + ",회사: " + companyName +",부서:" +department;
		}
		
	// getter, setter.
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
