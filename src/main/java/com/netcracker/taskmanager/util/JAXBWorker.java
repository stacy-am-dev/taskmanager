package com.netcracker.taskmanager.util;

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

    public static void saveObjectToFile(String fileName, Object o) throws JAXBException {
        marshaller.marshal(o, new File(fileName));
    }

    public static Object loadObjectFromFile(String fileName) throws JAXBException {
        return unmarshaller.unmarshal(new File(fileName));
    }

    private static void context(Class c) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(c);
    }

    private static void initialization() throws JAXBException {
        marshaller = jaxbContext.createMarshaller();
        unmarshaller = jaxbContext.createUnmarshaller();
    }
}
