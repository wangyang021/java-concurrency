package xiaomage;

import java.io.IOException;

/**
 * @Author: wy
 * @Date: 2019/4/27 20:33
 * @Description:
 */
public class ProcessCreate {
    public static void main(String[] args) throws IOException {
        // 创建打开windows计算器的进程
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("cmd /k http://www.baidu.com");
        process.exitValue();
    }

}
