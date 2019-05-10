package basic.visibility_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wy
 * @Date: 2019/5/9 16:00
 * @Description
 */
public class InterruptedTest {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
           while(true){

               System.out.println("无异常");
               if(Thread.currentThread().isInterrupted()){
                   System.out.println("异常了");
               }
           }
        });

        thread.start();
        thread.interrupt();

    }
}
