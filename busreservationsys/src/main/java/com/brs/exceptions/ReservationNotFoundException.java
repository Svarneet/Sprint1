package com.brs.exceptions;
@SuppressWarnings("serial")
public class ReservationNotFoundException extends Exception {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ReservationNotFoundException [msg=" + msg + "]";
	}

	public ReservationNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public ReservationNotFoundException() {
		super();
	}

}



	
	
	