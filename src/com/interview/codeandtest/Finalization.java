package com.interview.codeandtest;

public class Finalization {
    private static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalized");
        finalization=this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("first print"+f);
        f=null;
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second print"+f);
        System.out.println(f.finalization);
    }
}
