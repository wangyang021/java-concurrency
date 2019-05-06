package xiaomage;

import java.util.ArrayList;
import java.util.List;

public class CompleteAllThreadsQuestion {

    public static void main(String[] args) throws InterruptedException {

        // main 线程 -> 子线程
        Thread t1 = new Thread(CompleteAllThreadsQuestion::action, "t1");
        Thread t2 = new Thread(CompleteAllThreadsQuestion::action, "t2");
        Thread t3 = new Thread(CompleteAllThreadsQuestion::action, "t3");

        System.out.println("############");
        System.out.println(t1.isAlive());
        System.out.println(t1.getState());
        System.out.println("############");

        // 不确定 t1、t2、t3 是否调用 start()
        t1.start();
        System.out.println("############");
        System.out.println(t1.isAlive());
        System.out.println(t1.getState());
        System.out.println("############");

        t2.start();
        t3.start();

        List<Thread> threads = new ArrayList<>();
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);

        Thread.sleep(2000L);
        System.out.println("############");
        System.out.println(t1.isAlive());
        System.out.println(t1.getState());
        System.out.println("############");

        for (Thread thread : threads) {
            while (thread.isAlive()){
            }
            System.out.printf("当前活跃线程: %s\n", thread.getName());
        }

        System.out.println("dsfadsf");
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());  // 2
    }

}
