/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.writer;

/**
 *
 * @author Veljko
 * @param <T>
 */
public abstract class AbstractWriter<T> {

    protected String filePath;
    protected Class objectClass;
    protected T object;

    public void write(String filePath, T object) throws Exception {
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
        objectClass = object.getClass();
    }

    protected void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private void setObject(T object) {
        this.object = object;
    }

    protected abstract void initializeFileWriter() throws Exception;

    protected abstract void writeToFile() throws Exception;

    protected abstract void closeFile() throws Exception;

    protected void showMessage() {
        System.out.println("Object is successfully saved in file.");
    }

    public Class getObjectClass() {
        return objectClass;
    }

    protected abstract void setFileExtension();

}
