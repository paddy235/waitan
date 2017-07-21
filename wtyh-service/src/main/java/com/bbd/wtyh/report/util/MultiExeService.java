package com.bbd.wtyh.report.util;

import java.util.ArrayList;
import java.util.List;

/** 多任务执行服务
 * Created by cgj on 2017/7/21.
 */

public class MultiExeService {
    private boolean multithreading;

    /**
     *
     * @param multithreading 是否启用多线程
     */
    public MultiExeService(boolean multithreading) {
        this.multithreading = multithreading;
    }

    @FunctionalInterface
    public interface ThreadFun {
        void fun( );
    };
    public class ExeThread extends Thread {
        ThreadFun tf;
        ExeThread(ThreadFun tf ) {
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

    private List<ExeThread> thrList =new ArrayList();

    //创建带兰姆达表达式形式的线程对象、提交并将线程对象记录到列表中
    public void runThreadFun(  ThreadFun tf  ) {
        if( multithreading ) {
            ExeThread jt = new ExeThread(tf);
            jt.start();
            thrList.add(jt);
        } else {
            tf.fun();
        }
    }

    //等待所有线程执行结束后退出
    public  void waiting() {
        if (multithreading) {
            for (ExeThread jt : thrList) {
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
        ExeThread jt =new ExeThread(tf);
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
        MultiExeService jes =new MultiExeService(true);
        jes.test();
    }
}