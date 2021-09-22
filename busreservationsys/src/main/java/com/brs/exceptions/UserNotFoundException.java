package com.brs.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
private String msg;

public String getMsg() {
return msg;
}

public void setMsg(String msg) {
this.msg = msg;
}

@Override
public String toString() {
return "UserNotFoundException [msg=" + msg + "]";
}

public UserNotFoundException(String msg) {
super();
this.msg = msg;
}

public UserNotFoundException() {
super();
}

}