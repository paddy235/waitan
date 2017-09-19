package com.bbd.wtyh.report.util;

import java.util.ArrayList;
import java.util.LinkedList;
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
        final Exception []ee =new Exception []{null};
        ThreadFun tf;
        ExeThread(ThreadFun tf ) {
            super();
            this.tf =tf;
        }
        @Override
        public void run() {
            if( null != tf ) {
                try {
                    tf.fun();
                } catch (Exception e) {
                    ee[0] =e;
                    //e.printStackTrace();
                }
            }
        }
    }

    /** 线程异常列表 */
    private List<Exception> threadExceptionList =new LinkedList<>();

    public List<Exception> getThreadExceptionList() {
        return threadExceptionList;
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
        for (ExeThread jt : thrList) {
            if (jt.ee[0] !=null) {
                threadExceptionList.add(jt.ee[0]);
            }
        }
    }

    //等待列表中活动线程数小于指定Num
    public  void waitingNew( int Num ) {
        if (multithreading) {
            while (true) {
                int aNum = 0;
                List<ExeThread> rmList = new ArrayList();
                for (ExeThread jt : thrList) {
                    Thread.State tSt = jt.getState();
                    if (Thread.State.TERMINATED == tSt) {
                        rmList.add(jt);
                    } else {
                        aNum++;
                    }
                }
                thrList.removeAll(rmList);
                if ( aNum <Num || Num <=1 ) {
                    break;
                } else {
                    try { Thread.sleep(60); } catch (Exception e) {}
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