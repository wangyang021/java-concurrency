package xiaomage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wy
 * @Date: 2019/4/27 20:50
 * @Description:
 */
public class ThreadExeOrderQuestion {
    public static void main(String[] args) throws Exception {
//        joinTest();
//        System.out.println("**************");
//        loopTest();
        System.out.println("**************");
        waitTest();
//        System.out.println("**************");
//        singleThreadPoolTest();
    }
    // 单线程池实现
    private static void singleThreadPoolTest(){
        Thread t1 = new Thread(ThreadExeOrderQuestion::action, "1");
        Thread t2 = new Thread(ThreadExeOrderQuestion::action, "2");
        Thread t3 = new Thread(ThreadExeOrderQuestion::action, "3");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
    }


    // 使用wait实现
    private static void waitTest() throws Exception{
        Thread t1 = new Thread(ThreadExeOrderQuestion::action, "1");
        Thread t2 = new Thread(ThreadExeOrderQuestion::action, "2");
        Thread t3 = new Thread(ThreadExeOrderQuestion::action, "3");
        startAndWait(t1);
        startAndWait(t2);
        startAndWait(t3);
    }
    private static void startAndWait(Thread thread) throws Exception{
        if(Thread.State.NEW.equals(thread.getState())){
            thread.start();
        }
        while(thread.isAlive()){
            synchronized(thread){
                thread.wait(1000L);
            }
        }
    }

    // 使用状态.循环等待的方法
    private static void loopTest() throws InterruptedException {
        Thread t1 = new Thread(ThreadExeOrderQuestion::action, "1");
        Thread t2 = new Thread(ThreadExeOrderQuestion::action, "2");
        Thread t3 = new Thread(ThreadExeOrderQuestion::action, "3");

        t1.start();
        while (t1.isAlive()) {

        }
        t2.start();
        while (t2.isAlive()) {

        }
        t3.start();
        while (t3.isAlive()) {

        }
    }

    // 使用join 控制线程顺序
    private static void joinTest() throws InterruptedException {
        Thread t1 = new Thread(ThreadExeOrderQuestion::action, "1");
        Thread t2 = new Thread(ThreadExeOrderQuestion::action, "2");
        Thread t3 = new Thread(ThreadExeOrderQuestion::action, "3");

        t1.start();
        // 让主线程等待子线程运行结束后再继续运行
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行\n", Thread.currentThread().getName());
    }

}
