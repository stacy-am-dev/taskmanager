package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.exception.TaskManagerException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public final class ControllerProvider {
    private static ControllerProvider instance;
    private static HashMap<Class,String> controllers;

    private ControllerProvider()  throws TaskManagerException {
        try {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/resources/controllers.properties");
        property.load(fis);

        for (String key : property.stringPropertyNames())
        {
            Class cl = Class.forName(key);
            controllers.put(cl,property.getProperty(key));
        }

        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ControllerProvider getControllerProvider() throws TaskManagerException {
        if (instance == null) {
            instance = new ControllerProvider();
        }
        return instance;
    }

    public static <T> T getController(Class <T> Controller) throws TaskManagerException {
        try {
            String controllerImplementation = controllers.get(Controller);
            Class<T> cl = (Class<T>) Class.forName(controllerImplementation);
            Constructor<T> cons = cl.getDeclaredConstructor();
            return cons.newInstance();
        }
        catch (InstantiationException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
