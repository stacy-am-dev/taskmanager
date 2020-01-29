package com.netcracker.taskmanager.util;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface JAXBInterface {
    /**
     * Function saves object to XML-file
     * @param file
     * @param o
     */
    void saveObject(File file, Object o) throws JAXBException;

    /**
     * Function returns object from XML-file
     * @param file
     * @param c
     * @return Object
     */
    Object getObject(File file, Class c) throws JAXBException;
}
