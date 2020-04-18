package com;

import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object object=System.currentTimeMillis()%2==0?System.out:new ClassA();
         getPrintlnMH(object).invokeExact("icyfenix");
    }

    public static MethodHandle getPrintlnMH(Object receiver) throws Throwable{
        MethodType mt = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }
}
