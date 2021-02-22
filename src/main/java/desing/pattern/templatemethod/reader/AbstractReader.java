/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.reader;

/**
 *
 * @author Veljko
 * @param <T>
 */
public abstract class AbstractReader<T> {

    protected T object;
    protected String filePath;
    protected Class objectClass;

    public void read(String filePath, Class objectClass) throws Exception {
        setFilePath(filePath);
        setPathFileExtension();
        setObjectClass(objectClass);
        initializeFileReader();
        readFromFile();
        createReport();
        closeFile();
    }

    protected void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private void setObjectClass(Class objectClass) {
        this.objectClass = objectClass;
    }

    protected abstract void setPathFileExtension() throws Exception;

    protected abstract void initializeFileReader() throws Exception;

    protected abstract void readFromFile() throws Exception;

    protected void createReport() {
        System.out.println(object);
    }

    protected abstract void closeFile() throws Exception;

}
