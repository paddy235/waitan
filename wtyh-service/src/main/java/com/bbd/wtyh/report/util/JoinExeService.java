package com.bbd.wtyh.report.util;

import java.util.ArrayList;
import java.util.List;

/** 多任务运行管理
 * Created by cgj on 2017/7/21.
 */

public class JoinExeService {
    private boolean multithreading;

    /**
     *
     * @param multithreading 是否启用多线程
     */
    public JoinExeService(boolean multithreading) {
        this.multithreading = multithreading;
    }

    @FunctionalInterface
    public interface ThreadFun {
        void fun( );
    };
    public class JoinThread extends Thread {
        ThreadFun tf;
        JoinThread( ThreadFun tf ) {
            super();
            this.tf =tf;
        }
        @Override
        public void run() {
            if( null != tf ) {
                tf.fun();
            }
        }
    }

    private List<JoinThread> thrList =new ArrayList();

    //创建带兰姆达函数参数的线程对象、提交线程并将线程对象记录到列表中
    public void runThreadFun(  ThreadFun tf  ) {
        if( multithreading ) {
            JoinThread jt = new JoinThread(tf);
            jt.start();
            thrList.add(jt);
        } else {
            tf.fun();
        }
    }

    //等待所有线程执行结束后退出
    public  void waitJoin() {
        if (multithreading) {
            for (JoinThread jt : thrList) {
                try {
                    jt.join();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public void test () {
        ThreadFun tf =()->{
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        };
        JoinThread jt =new JoinThread(tf);
        jt.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e) {}
        try {
            jt.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        try {
            jt.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String []argc) {
        JoinExeService jes =new JoinExeService(true);
        jes.test();
    }
}