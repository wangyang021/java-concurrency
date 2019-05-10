package basic.visibility_3;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: wy
 * @Date: 2019/5/8 19:33
 * @Description:
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time");
                try {
                    Thread.sleep(5000L);  // 该线程执行时间过长，影响其他线程执行时间点
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //throw new RuntimeException();  // 抛出异常时，会停止整个timer
            }
        },1000L);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time11");
            }
        },2000L);
    }

}
