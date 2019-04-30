/**
 * Copyright (C), 2018, 链家网
 * FileName: VolitateTest
 * Author:   wy
 * Date:     2019/4/23 15:09
 * Description:
 */
package basic.visibility_3;

public class VolitateTest {
    Integer abc;

    class MyTread1 extends Thread {
        @Override
        public void run()  {
            super.run();
            while (true) {
                try {
                    Thread.sleep(1000);
                }catch (Exception ex){

                }
                System.out.println("输出abc:" + abc);
            }
        }
    }

    public static void main(String[] args) {
        VolitateTest volitateTest = new VolitateTest();

    }

}
