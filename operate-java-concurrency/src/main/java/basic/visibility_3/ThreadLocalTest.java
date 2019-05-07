package basic.visibility_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: wy
 * @Date: 2019/5/7 14:30
 * @Description:
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();

        new Thread(() -> {
            threadLocal.set(1);
        }, "thread1").start();

        new Thread(() -> {
            threadLocal.set(2);
        }, "thread2").start();

        System.out.println(threadLocal.get());

    }

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>() {
        @Override
        public Connection initialValue() {
            try {
                return DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection getConnection() {
        return connectionThreadLocal.get();
    }

}
