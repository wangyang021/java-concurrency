package basic.visibility_3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: wy
 * @Date: 2019/5/10 18:11
 * @Description:
 */
public class LockTest {
    public static void main(String[] args) {
        System.out.println(System.identityHashCode("saafsdfs"));
        Lock lock = new ReentrantLock();
        lock.tryLock();
        ReentrantLock reentrantLock = new ReentrantLock();
        ReadWriteLock readWriteLock =new ReentrantReadWriteLock();
        readWriteLock.writeLock().lock();

    }

}
