package com.bbd.wtyh.test;

/**
 * 
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static void main(String[] args) {
        String userName="中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中";
        String regStr = "^.{1,30}$";
        System.out.println(userName.matches(regStr));
    }

}
