/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.reader;

import java.io.File;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Veljko
 * @param <T>
 */
public class XMLReader<T> extends AbstractReader<T> {

    private JAXBContext jaxbContext;
    private Unmarshaller jaxbUnmarshaller;
    private File xmlFile;
    private DataHandler dataHandler;

    @Override
    protected void setPathFileExtension() {
        filePath += ".xml";
    }

    @Override
    protected void initializeFileReader() throws Exception {
        jaxbContext = JAXBContext.newInstance(objectClass);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        xmlFile = new File(filePath);
        dataHandler = new DataHandler(new FileDataSource(xmlFile));
    }

    @Override
    protected void readFromFile() throws Exception {
        JAXBElement<T> root = jaxbUnmarshaller.unmarshal(new StreamSource(dataHandler.getDataSource().getInputStream()), objectClass);
        object = root.getValue();
    }

    @Override
    protected void closeFile() throws Exception {
        dataHandler.getDataSource().getInputStream().close();
    }

}
