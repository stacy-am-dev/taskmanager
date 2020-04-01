package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.exception.TaskManagerException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.netcracker.taskmanager.Constants.JAXB_EXCEPTION;

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
            throw new TaskManagerException(new JAXBException("Problem with save object to file"), JAXB_EXCEPTION);
        }
    }

    public static Object loadObjectFromFile(String fileName) throws TaskManagerException {
        try {
            return getUnmarshaller().unmarshal(new File(fileName));
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException("Problem with load object from file"), JAXB_EXCEPTION);
        }
    }

    private static JAXBContext createContext() throws TaskManagerException {
        try {
            return JAXBContext.newInstance();
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException("Problem with context initialization"), JAXB_EXCEPTION);
        }
    }

    public static JAXBContext getJaxbContext() throws TaskManagerException {
        if (jaxbContext == null)
            jaxbContext = createContext();
        return jaxbContext;
    }

    public static Marshaller getMarshaller() throws TaskManagerException {
        try {
            if (marshaller == null)
                marshaller = getJaxbContext().createMarshaller();
            return marshaller;
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException("Problem with marshaller initialization"), JAXB_EXCEPTION);
        }

    }

    public static Unmarshaller getUnmarshaller() throws TaskManagerException {
        try {
            if (unmarshaller == null)
                unmarshaller = getJaxbContext().createUnmarshaller();
            return unmarshaller;
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException("Problem with unmarshaller initialization"), JAXB_EXCEPTION);
        }
    }
}
