/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.writer;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 *
 * @author Veljko
 * @param <T>
 */
public class XMLWriter<T> extends AbstractWriter<T> {

    private JAXBElement<T> jaxbElement;
    private Marshaller jaxbMarshaller;
    private File xmlFile;
    private static final String XML_EXTENSION = ".xml";

    @Override
    protected void initializeFileWriter() throws Exception {
        xmlFile = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    @Override
    protected void setFileExtension() {
        filePath += XML_EXTENSION;
    }

    @Override
    protected void writeToFile() throws Exception {
        jaxbElement = new JAXBElement<>(new QName("", object.getClass().getSimpleName().toLowerCase()),
                objectClass,
                object);
        jaxbMarshaller.marshal(jaxbElement, xmlFile);
    }

    @Override
    protected void closeFile() {
        xmlFile = null;
    }
}
