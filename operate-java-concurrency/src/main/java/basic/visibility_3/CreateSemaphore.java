package basic.visibility_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.crypto.Cipher;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @Author: wy
 * @Date: 2019/5/14 11:04
 * @Description:
 */
@ThreadSafe
public class CreateSemaphore {
    private final Lock lock = new ReentrantLock();
    private final Condition permitsAvailable = lock.newCondition();
    @GuardedBy("lock")
    private int permits;

    CreateSemaphore(int initPermits) {
        lock.lock();
        try {
            this.permits = initPermits;
        } finally {
            lock.unlock();
        }
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                permitsAvailable.await();
            }
            permits--;
        } finally {
            lock.unlock();
        }
    }

    public void release(){
        lock.unlock();
        try{
            permits++;
            permitsAvailable.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
