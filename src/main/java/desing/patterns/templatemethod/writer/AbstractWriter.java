/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.writer;

import desing.patterns.templatemethod.domain.FileHandlingException;

/**
 * @param <T>
 * @author Veljko
 */
public abstract class AbstractWriter<T> {

    protected String filePath;
    protected Class<T> objectClass;
    protected T object;

    public void write(final String filePath, final T object) throws FileHandlingException {
        setFilePath(filePath);
        setObject(object);
        setObjectClass();
        setFileExtension();
        initializeFileWriter();
        writeToFile();
        closeFile();
        showMessage();
    }

    protected void setObjectClass() {
        objectClass = (Class<T>) object.getClass();
    }

    protected void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    private void setObject(final T object) {
        this.object = object;
    }

    protected abstract void initializeFileWriter() throws FileHandlingException;

    protected abstract void writeToFile() throws FileHandlingException;

    protected abstract void closeFile() throws FileHandlingException;

    protected void showMessage() {
        System.out.println("Object is successfully saved in file.");
    }

    protected abstract void setFileExtension();

}
