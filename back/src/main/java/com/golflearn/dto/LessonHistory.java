package com.golflearn.dto;

import java.util.Date;

public class LessonHistory {
	private int lsnLineNo;
	private String lsnFdbk;
	private Date lsnChkDt;
	private Date lsnStartDt;
	private int currentLsnCnt;
	private String strLsnChkDt;
	private String strLsnStartDt;
	
	
	public int getLsnLineNo() {
		return lsnLineNo;
	}
	public void setLsnLineNo(int lsnLineNo) {
		this.lsnLineNo = lsnLineNo;
	}
	public String getLsnFdbk() {
		return lsnFdbk;
	}
	public void setLsnFdbk(String lsnFdbk) {
		this.lsnFdbk = lsnFdbk;
	}
	public Date getLsnChkDt() {
		return lsnChkDt;
	}
	public void setLsnChkDt(Date lsnChkDt) {
		this.lsnChkDt = lsnChkDt;
	}
	public Date getLsnStartDt() {
		return lsnStartDt;
	}
	public void setLsnStartDt(Date lsnStartDt) {
		this.lsnStartDt = lsnStartDt;
	}
	public int getCurrentLsnCnt() {
		return currentLsnCnt;
	}
	public void setCurrentLsnCnt(int currentLsnCnt) {
		this.currentLsnCnt = currentLsnCnt;
	}
	public String getStrLsnStartDt() {
		return strLsnStartDt;
	}
	public void setStrLsnStartDt(String strLsnStartDt) {
		this.strLsnStartDt = strLsnStartDt;
	}
	public String getStrLsnChkDt() {
		return strLsnChkDt;
	}
	public void setStrLsnChkDt(String strLsnChkDt) {
		this.strLsnChkDt = strLsnChkDt;
	}
	
}
