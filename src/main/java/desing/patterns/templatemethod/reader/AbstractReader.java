/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.reader;

import desing.patterns.templatemethod.domain.FileHandlingException;

/**
 * @param <T>
 * @author Veljko
 */
public abstract class AbstractReader<T> {

    protected T object;
    protected String filePath;
    protected Class<T> objectClass;

    public void read(final String filePath, final Class<T> objectClass) throws FileHandlingException {
        setFilePath(filePath);
        setPathFileExtension();
        setObjectClass(objectClass);
        initializeFileReader();
        readFromFile();
        createReport();
        closeFile();
    }

    protected void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    private void setObjectClass(final Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    protected abstract void setPathFileExtension() throws FileHandlingException;

    protected abstract void initializeFileReader() throws FileHandlingException;

    protected abstract void readFromFile() throws FileHandlingException;

    protected void createReport() {
        System.out.println(object);
    }

    protected abstract void closeFile() throws FileHandlingException;

}
