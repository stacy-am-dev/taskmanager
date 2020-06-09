package com.netcracker.taskmanager.util;


import com.netcracker.taskmanager.exception.TaskManagerException;
import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;


public class ModelFacade {
    private static ModelFacade instance;
    private Model model;
    private static final Logger LOGGER = Logger.getLogger(ModelFacade.class);
    private Timer timer = new Timer();

    private ModelFacade() throws TaskManagerException {
        loadModel();
        Autosave auto = new Autosave();
        timer.schedule(auto, 0, 10000);
    }

    public static synchronized ModelFacade getInstance() throws TaskManagerException {
        if (instance == null)
            instance = new ModelFacade();
        return instance;
    }

    public Model getModel() {
        return model;
    }


    public void saveModel() throws TaskManagerException {
        JAXBWorker.saveObjectToFile("model.xml", getInstance().getModel());
    }

    public void loadModel() throws TaskManagerException {
        model = (Model) JAXBWorker.loadObjectFromFile("model.xml");
    }

    public void closeModel() throws TaskManagerException {
        timer.cancel();
        saveModel();
    }

    class Autosave extends TimerTask {
        @Override
        public void run() {
            try {
                saveModel();
            } catch (TaskManagerException e) {
                LOGGER.error("Problems with autosaving",e);
            }
        }
    }

}

