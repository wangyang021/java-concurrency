package xiaomage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wy
 * @Date: 2019/4/27 19:56
 * @Description:
 */
public class TreadCreate {
    public static void main(String[] args) throws  Exception {
        // 主线程 -> 创建子线程
        Thread thread = new Thread(()->{

        },"线程名");

        //线程池创建
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{

        });

        thread.run();
        thread.destroy();
    }


}
