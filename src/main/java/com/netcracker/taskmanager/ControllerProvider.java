package com.netcracker.taskmanager;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.Constants.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

import static com.netcracker.taskmanager.Constants.*;

public final class ControllerProvider {
    private static ControllerProvider instance;
    private static HashMap<Class,String> controllers;

    private ControllerProvider()  throws TaskManagerException {
        try {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/java/com/netcracker/taskmanager/controllers.properties");
        property.load(fis);

        for (String key : property.stringPropertyNames())
        {
            Class cl = Class.forName(key);
            controllers.put(cl,property.getProperty(key));
        }

        } catch (FileNotFoundException e) {
            throw new TaskManagerException(e, FILE_NOT_FOUND_EXCEPTION);
        } catch (ClassNotFoundException e) {
            throw new TaskManagerException(e, CLASS_NOT_FOUND_EXCEPTION);
        } catch (IOException e) {
            throw new TaskManagerException(e, IOEXCEPTION);
        }
    }

    public static synchronized ControllerProvider createControllerProvider() throws TaskManagerException {
        if (instance == null) {
            instance = new ControllerProvider();
        }
        return instance;
    }

    public static <T> T getInstance(Class <T> Controller) throws TaskManagerException {
        try {
            String controllerImplementation = controllers.get(Controller);
            Class<T> wow = (Class<T>) Class.forName(controllerImplementation);
            Constructor<T> cons = wow.getDeclaredConstructor();
            return cons.newInstance();

        } catch (InstantiationException e) {
            throw new TaskManagerException(e, INSTANTIATION_EXCEPTION);
        } catch (InvocationTargetException e) {
            throw new TaskManagerException(e, INVOCATION_TARGET_EXCEPTION);
        } catch (NoSuchMethodException e) {
            throw new TaskManagerException(e, NO_SUCH_METHOD_EXCEPTION);
        } catch (IllegalAccessException e) {
            throw new TaskManagerException(e, ILLEGAL_ACCESS_EXCEPTION);
        } catch (ClassNotFoundException e) {
            throw new TaskManagerException(e, CLASS_NOT_FOUND_EXCEPTION);
        }

    }
}
