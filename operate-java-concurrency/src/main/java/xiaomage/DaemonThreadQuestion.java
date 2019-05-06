package xiaomage;

public class DaemonThreadQuestion {

    public static void main(String[] args) {
        // main 线程
        Thread t1 = new Thread(() -> {
            System.out.println("Hello,World");
        }, "daemon");
        // 编程守候线程
        t1.setDaemon(true);
        t1.start();

        // 守候线程的执行依赖于执行时间（非唯一评判）
    }
}
