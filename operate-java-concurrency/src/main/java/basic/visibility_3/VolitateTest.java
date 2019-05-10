/**
 * Copyright (C), 2018, 链家网
 * FileName: VolitateTest
 * Author:   wy
 * Date:     2019/4/23 15:09
 * Description:
 */
package basic.visibility_3;

import java.util.Collections;

public class VolitateTest {

//    private String name;
//
//    VolitateTest(){
//        new Thread(()->{
//            VolitateTest volitateTest = this;
//            this.name = "111";
//        });
//    }

    public static class MyTread extends Thread {

        private volatile  boolean asleep = false;

        @Override
        public void run() {
            while (!asleep) {
                System.out.println("没睡着");
            }
            System.out.println("睡着了");
        }

        public void setAsleep(boolean asleep) {
            this.asleep = asleep;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTread myTread = new MyTread();
        myTread.start();

        Thread.sleep(1000L);
        myTread.setAsleep(true);

    }

}
