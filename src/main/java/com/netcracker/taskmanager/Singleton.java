package com.netcracker.taskmanager;


import com.netcracker.taskmanager.model.Process;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;




public class Singleton {
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }



    public Process upload(InputStream in) {
        Process process = new Process();
        process.upload(in);
        return process;
    }
}