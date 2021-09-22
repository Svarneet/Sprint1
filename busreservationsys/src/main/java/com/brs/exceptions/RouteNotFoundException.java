
package com.brs.exceptions;
@SuppressWarnings("serial")
public class RouteNotFoundException extends Exception {
private String msg;

public String getMsg() {
return msg;
}

public void setMsg(String msg) {
this.msg = msg;
}

@Override
public String toString() {
return "RouteNotFoundException [msg=" + msg + "]";
}

public RouteNotFoundException(String msg) {
super();
this.msg = msg;
}

public RouteNotFoundException() {
super();
}

}