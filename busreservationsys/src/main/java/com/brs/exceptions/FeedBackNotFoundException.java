package com.brs.exceptions;

@SuppressWarnings("serial")
public class FeedBackNotFoundException extends Exception {
	private String msg;
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "FeedBackNotFoundException [msg=" + msg + "]";
	}

	public FeedBackNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public FeedBackNotFoundException() {
		super();
	}

}
