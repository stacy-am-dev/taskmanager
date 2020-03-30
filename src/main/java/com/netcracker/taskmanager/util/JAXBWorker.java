package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.exception.TaskManagerException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Class describes saving object to XML-file and return of object from XML-file
 */
public class JAXBWorker {
    private static JAXBContext jaxbContext = null;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    public static void saveObjectToFile(String fileName, Object o) throws TaskManagerException {
        try {
            getMarshaller().marshal(o, new File(fileName));
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }
    }

    public static Object loadObjectFromFile(String fileName) throws TaskManagerException {
        try {
            return getUnmarshaller().unmarshal(new File(fileName));
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }
    }

    private static JAXBContext createContext() throws TaskManagerException {
        try {
            return JAXBContext.newInstance();

        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }
    }

    public static JAXBContext getJaxbContext() throws TaskManagerException {
        if (jaxbContext != null)
            return jaxbContext;
        else return jaxbContext = createContext();
    }

    public static Marshaller getMarshaller() throws TaskManagerException {
        try {
            if (marshaller != null)
                return marshaller;
            else return marshaller = getJaxbContext().createMarshaller();
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }

    }

    public static Unmarshaller getUnmarshaller() throws TaskManagerException {
        try {
            if (unmarshaller != null)
                return unmarshaller;
            else return unmarshaller = getJaxbContext().createUnmarshaller();
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }
    }
}
