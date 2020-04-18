package com.interview.codeandtest;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String path;
    private String classloaderName;

    public MyClassLoader(String path, String myclassloader) {
        this.path = path;
        this.classloaderName = myclassloader;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b=loadClassDate(name);
        return defineClass(name,b,0,b.length);
    }

    private byte[] loadClassDate(String name)  {
        name=path+name+".class";
        InputStream in=null;
        ByteArrayOutputStream out=null;
        try {
            in = new FileInputStream(new File(name));
            out=new ByteArrayOutputStream();
            int i=0;
            while((i=in.read())!=-1){
                out.write(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
