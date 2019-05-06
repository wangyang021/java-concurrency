package xiaomage;

/**
 * @Author: wy
 * @Date: 2019/5/6 11:38
 * @Description:
 */
public class MainThreadExitQuestion {
    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                System.out.println("子线程执行");
            }
        }).start();

        Thread.currentThread().stop();
    }


}
