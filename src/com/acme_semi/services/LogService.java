package com.acme_semi.services;

public class LogService {

    public String logoutput = "";

    public void loginfoln(Object... msgobjs) {
        if (msgobjs == null || msgobjs.length == 0) {
            System.out.println();
            logoutput = logoutput + "\n";
        } else {
            for (Object msgobj : msgobjs) {
                System.out.println(msgobj.toString());
                logoutput = logoutput + msgobj.toString() + "\n";
            }
        }
    }

    public void loginfo(Object... msgobjs) {
        if (msgobjs != null) {
            for (Object msgobj : msgobjs) {
                System.out.print(msgobj.toString());
                logoutput = logoutput + msgobj.toString();
            }
        }
    }

    public void clearoutput() {
        logoutput = "";
    }
}
