package main;


import java.io.*;

import main.java.com.netcracker.taskmanager.tasks.model.Process;




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

    public void save(Process process, OutputStream out) throws IOException {
//        FileWriter out = new FileWriter("Process");
//        out.write(process.getName() + " " + process.getStartDate() + " " + process.getEndDate() + " " + process.getDescription());

        process.saveToFile(out);
    }

    public Process upload(InputStream in) {
        Process process = new Process();
        process.upload(in);
    }
}