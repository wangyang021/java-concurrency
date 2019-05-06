package xiaomage;

/**
 * @Author: wy
 * @Date: 2019/5/5 17:47
 * @Description:
 */
public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        Action1 action1 = new Action1();
        Thread thread1 = new Thread(action1, "t1");
        thread1.start();
        Thread.sleep(500L);
        action1.setStopped(true);
        thread1.join();

        Action2 action2 = new Action2();
        Thread thread2 = new Thread(action2, "t2");
        thread2.start();
        Thread.sleep(500L);
        thread2.interrupt();
        thread2.join();
        if(!thread2.isInterrupted()){
            System.out.println("线程2中断了");
        }
    }

    private static class Action2 implements Runnable{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                action();
            }

        }
    }

    private static class Action1 implements Runnable {
        private volatile boolean stopped = false;

        @Override
        public void run() {
            while (!stopped) {
                action();
            }
        }

        public void setStopped(boolean stopped) {
            this.stopped = stopped;
        }
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());  // 2
    }
}
