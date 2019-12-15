package com.netcracker.taskmanager;


public class ModelFacade {
    private static ModelFacade instance;
    private Model model;

    private ModelFacade() {
        model = new Model();
    }

    public static synchronized ModelFacade getInstance() {
        if (instance == null)
            instance = new ModelFacade();
        return instance;
    }

    public Model getModel() {
        return model;
    }
}

