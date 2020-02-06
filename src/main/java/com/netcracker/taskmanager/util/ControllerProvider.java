package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.exception.TaskManagerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;

import static com.netcracker.taskmanager.Constants.*;

public final class ControllerProvider {
    private static ControllerProvider instance;
    private Map<Class, Class> controllers;

    private ControllerProvider() throws TaskManagerException {
        try (FileInputStream fis = new FileInputStream("src/main/resources/controllers.properties");) {
            Properties property = new Properties();
            property.load(fis);

            for (String key : property.stringPropertyNames()) {
                Class cl = Class.forName(key);
                controllers.put(cl, Class.forName(property.getProperty(key)));
            }

        } catch (ClassNotFoundException | IOException e) {
            throw new TaskManagerException(e, CONTROLLER_PROVIDER_INITIALIZATION_ERROR);
        }
    }

    public static synchronized ControllerProvider getControllerProvider() throws TaskManagerException {
        if (instance == null) {
            instance = new ControllerProvider();
        }
        return instance;
    }

    public <T> T getController(Class<T> Controller) throws TaskManagerException {
        try {
            Class cl = this.controllers.get(Controller);
            Constructor cons = cl.getDeclaredConstructor();
            return (T) cons.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new TaskManagerException(e, GET_CONTROLLER_ERROR);
        }
    }
}

