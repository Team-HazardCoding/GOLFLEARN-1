package com.golflearn.dto;

public class LessonClsfc {
	private int clubNo;
	private int lsnNo;
	
	public LessonClsfc() {
	}	
	
	public LessonClsfc(int clubNo, int lsnNo) {
		this.clubNo = clubNo;
		this.lsnNo = lsnNo;
	}
	public int getClubNo() {
		return clubNo;
	}
	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	public int getLsnNo() {
		return lsnNo;
	}
	public void setLsnNo(int lsnNo) {
		this.lsnNo = lsnNo;
	}
}
