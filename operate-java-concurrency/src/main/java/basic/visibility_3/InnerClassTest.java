/**
 * Copyright (C), 2018, 链家网
 * FileName: InnerClassTest
 * Author:   wy
 * Date:     2019/4/24 10:36
 * Description: 内部类可以获取外部类引用，并可以对外暴露
 */
package basic.visibility_3;

import org.junit.Test;

public class InnerClassTest {
    private Integer aaa = 1;

    class InnerClass {
        private Integer  aaa = 2;

        public  void  out(){
            System.out.println("内部内aaa"+aaa);
            System.out.println("外部内aaa"+InnerClassTest.this.aaa);
        }

        public InnerClassTest getOutClassInner(){
            InnerClassTest innerClassTest = InnerClassTest.this;
            return innerClassTest;
        }
    }


    public InnerClass returnInnerClassInstance() {
        InnerClass innerClass = new InnerClass();
        innerClass.out();
        return innerClass;
    }

    @Test
    public void test1(){
        InnerClass innerClass = returnInnerClassInstance();
        System.out.println(innerClass.getOutClassInner().aaa);
    }
}
