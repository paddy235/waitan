package com.bbd.wtyh.web.util;

/**
 * Created by win7 on 2016/8/2.
 */
public class Q2 {
    private Q2 q2 = null;

    private Q2() {}

    // CAS
    public Q2 getQ2() {
        synchronized (this) {
            if (q2 == null) {
                q2 = new Q2();
                return q2;
            } else {
                return q2;
            }
        }
    }
}
