/**
 * Copyright (C), 2018, 链家网
 * FileName: NoVisibility
 * Author:   wy
 * Date:     2019/4/22 16:36
 * Description: 无同步机制下共享变量
 */
package basic.visibility_3;

import javax.annotation.Generated;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(ready);
                Thread.yield();
                //System.out.println(number);
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
