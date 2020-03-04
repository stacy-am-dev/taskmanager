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
    private static JAXBContext jaxbContext;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    public static void saveObjectToFile(String fileName, Object o) throws TaskManagerException {
        try {
            if (jaxbContext != null && marshaller != null) {
                marshallerInitialization();
                context(o.getClass());
                marshaller.marshal(o, new File(fileName));
            }
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }
    }

    public static Object loadObjectFromFile(String fileName, Object o) throws TaskManagerException {
        try {
            if (jaxbContext != null && unmarshaller != null) {
                context(o.getClass());
                unmarshalInitialization();
                return unmarshaller.unmarshal(new File(fileName));
            }
        } catch (JAXBException e) {
            throw new TaskManagerException(new JAXBException(""), 234);
        }
        return null;
    }

    private static void context(Class c) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(c);
    }

    private static void marshallerInitialization() throws JAXBException {
        marshaller = jaxbContext.createMarshaller();
    }

    private static void unmarshalInitialization() throws JAXBException {
        unmarshaller = jaxbContext.createUnmarshaller();
    }
}
