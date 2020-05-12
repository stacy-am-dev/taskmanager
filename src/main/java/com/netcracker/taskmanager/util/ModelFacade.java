package com.netcracker.taskmanager.util;


import com.netcracker.taskmanager.exception.TaskManagerException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

import static com.netcracker.taskmanager.Constants.AUTOSAVE_ERROR;


public class ModelFacade {
    private static ModelFacade instance;
    private Model model;
    private static final Logger LOGGER = Logger.getLogger(ModelFacade.class);


    private ModelFacade() throws TaskManagerException {
        try {
            FileInputStream fis = new FileInputStream("model");
            ObjectInputStream ois = new ObjectInputStream(fis);
            model= (Model) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new TaskManagerException(new Throwable(""), AUTOSAVE_ERROR);
        }
        Timer timer = new Timer();
        timer.schedule(new Autosave(), 0, 10000);
    }

    public static synchronized ModelFacade getInstance() throws TaskManagerException {
        if (instance == null)
            instance = new ModelFacade();
        return instance;
    }

    public Model getModel() {
        return model;
    }

     static class Autosave extends TimerTask {
        @Override
        public void run() {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("model");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(getInstance().getModel());
            } catch (IOException | TaskManagerException e) {
                try {
                    throw new TaskManagerException(new Throwable(""), AUTOSAVE_ERROR);
                } catch (TaskManagerException ex) {
                    LOGGER.error("Problems with autosaving");                }
            }
        }
    }
}


