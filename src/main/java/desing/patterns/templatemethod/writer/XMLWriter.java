/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.writer;

import desing.patterns.templatemethod.domain.FileHandlingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.File;

/**
 * @param <T>
 * @author Veljko
 */
public class XMLWriter<T> extends AbstractWriter<T> {

    private Marshaller jaxbMarshaller;
    private File xmlFile;
    private static final String XML_EXTENSION = ".xml";

    @Override
    protected void initializeFileWriter() throws FileHandlingException {
        try {
            xmlFile = new File(filePath);
            final JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (final JAXBException e) {
            throw new FileHandlingException("Exception during init stream to file:" + filePath, e);
        }
    }

    @Override
    protected void setFileExtension() {
        filePath += XML_EXTENSION;
    }

    @Override
    protected void writeToFile() throws FileHandlingException {
        try {
            final JAXBElement<T> jaxbElement = new JAXBElement<>(new QName("", object.getClass().getSimpleName().toLowerCase()),
                    objectClass,
                    object);
            jaxbMarshaller.marshal(jaxbElement, xmlFile);
        } catch (final JAXBException e) {
            throw new FileHandlingException("Exception during writing to file: " + filePath, e);
        }
    }

    @Override
    protected void closeFile() {
        xmlFile = null;
    }
}
