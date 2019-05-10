package basic.visibility_3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wy
 * @Date: 2019/5/8 19:39
 * @Description:
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(()->{
            System.out.println("线程2");
        },2000L,TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(()->{
            System.out.println("线程1");
        },1000,5000, TimeUnit.MILLISECONDS);

    }

}
