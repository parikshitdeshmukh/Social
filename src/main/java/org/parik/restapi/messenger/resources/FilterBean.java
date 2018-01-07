package org.parik.restapi.messenger.resources;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class FilterBean {
	
	
	
	private @QueryParam("year") int year;
	private  @QueryParam("start") int start;
	private  @QueryParam("size") int size;
	private @PathParam("messageId") int msgId;
	private @PathParam("commentId") int cmtId;

	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getCmtId() {
		return cmtId;
	}
	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	

}
