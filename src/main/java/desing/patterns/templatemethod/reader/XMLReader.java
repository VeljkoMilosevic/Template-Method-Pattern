/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.reader;

import desing.patterns.templatemethod.domain.FileHandlingException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/**
 * @param <T>
 * @author Veljko
 */
public class XMLReader<T> extends AbstractReader<T> {

    private Unmarshaller jaxbUnmarshaller;
    private DataHandler dataHandler;

    @Override
    protected void setPathFileExtension() {
        filePath += ".xml";
    }

    @Override
    protected void initializeFileReader() throws FileHandlingException {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            final File xmlFile = new File(filePath);
            dataHandler = new DataHandler(new FileDataSource(xmlFile));
        } catch (final JAXBException e) {
            throw new FileHandlingException("Exception during init stream to xml file: " + filePath, e);
        }
    }

    @Override
    protected void readFromFile() throws FileHandlingException {
        try {
            final JAXBElement<T> root = jaxbUnmarshaller.unmarshal(new StreamSource(dataHandler.getDataSource().getInputStream()), objectClass);
            object = root.getValue();
        } catch (final JAXBException | IOException e) {
            throw new FileHandlingException("Exception during reading file on path:" + filePath, e);
        }
    }

    @Override
    protected void closeFile() throws FileHandlingException {
        try {
            dataHandler.getDataSource().getInputStream().close();
        } catch (final IOException e) {
            throw new FileHandlingException("Exception during closing file: " + filePath, e);
        }
    }

}
