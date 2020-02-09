package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.exception.TaskManagerException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import static com.netcracker.taskmanager.Constants.*;

public final class ControllerProvider {
    private static ControllerProvider instance;
    private Map<Class, Class> controllers;
    private static final String FILE_NAME = "controllers.properties";
    final static Logger logger = Logger.getLogger(ControllerProvider.class);

    private ControllerProvider() throws TaskManagerException {
        ClassLoader classLoader = ControllerProvider.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(FILE_NAME)).getFile());
        try (FileInputStream fis = new FileInputStream(file)) {
            Properties property = new Properties();
            property.load(fis);
            for (String key : property.stringPropertyNames()) {
                Class cl = Class.forName(key);
                controllers.put(cl, Class.forName(property.getProperty(key)));
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Problems with initialization of controller provider",e);
            throw new TaskManagerException(e, CONTROLLER_PROVIDER_INITIALIZATION_ERROR);
        }

    }

    public static synchronized ControllerProvider getControllerProvider() throws TaskManagerException {
        if (instance == null) {
            instance = new ControllerProvider();
        }
        return instance;
    }

    public <T> T getController(Class<T> controller) throws TaskManagerException {
        try {
            Class cl = this.controllers.get(controller);
            Constructor cons = cl.getDeclaredConstructor();
            return (T) cons.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

            logger.error("Problems with getting controller",e);
            throw new TaskManagerException(e, GET_CONTROLLER_ERROR);
        }
    }
}

