package basic.visibility_3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.runner.notification.RunListener;

import net.jcip.annotations.GuardedBy;

/**
 * @Author: wy
 * @Date: 2019/5/13 14:37
 * @Description:
 */
@RunListener.ThreadSafe
public class SelfDefineSynUtil<T> {
    protected final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private int defaultSize = 10;
    @GuardedBy("lock")
    private final T[] items = (T[]) new Object[defaultSize];

    private int tail,head,count;


    public SelfDefineSynUtil() {

    }
    public SelfDefineSynUtil(int size) {
        this.defaultSize = size;
    }

    public void put(T s) throws InterruptedException {
        lock.lock();
        try {
            while(count==defaultSize){
                notFull.await();
            }
            items[tail] = s;
            ++tail;
            if(tail==defaultSize){
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T get() throws InterruptedException {
        lock.lock();
        try {
            while(count ==0){
                notEmpty.await();
            }
            T item = items[head];
            ++head;
            if(head==defaultSize){
                head = 0;
            }
            --count;
            notFull.signal();
            return item;
        }finally {
            lock.unlock();
        }
    }


}
