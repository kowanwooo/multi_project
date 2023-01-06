package com.multi.animal.missingBoard;

import java.util.Map;

public class MissingBoardVO {
	private int missingId;
	private String userId;
	private String title;
	private String location;
	private String tel;
	private String pet;
	private String createAt;
	private String description;
	private int gratuity;
	private String img;
	private int rule;
	private String missingDate;

	public int getMissingId() {
		return missingId;
	}

	public void setMissingId(int missingId) {
		this.missingId = missingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGratuity() {
		return gratuity;
	}

	public void setGratuity(int gratuity) {
		this.gratuity = gratuity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public String getMissingDate() {
		return missingDate;
	}

	public void setMissingDate(String missingDate) {
		this.missingDate = missingDate;
	}

	@Override
	public String toString() {
		return "MissingBoardVO [missingId=" + missingId + ", userId=" + userId + ", title=" + title + ", location="
				+ location + ", tel=" + tel + ", pet=" + pet + ", createAt=" + createAt + ", description=" + description
				+ ", gratuity=" + gratuity + ", img=" + img + ", rule=" + rule + ", missingDate=" + missingDate + "]";
	}

	
}
