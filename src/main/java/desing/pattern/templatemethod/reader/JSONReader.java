/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.reader;

import com.google.gson.Gson;
import java.io.FileReader;

/**
 *
 * @author Veljko
 * @param <T>
 */
public class JSONReader<T> extends AbstractReader<T> {

    private Gson gson;

    @Override
    protected void setPathFileExtension() {
        filePath += ".json";
    }

    @Override
    protected void initializeFileReader() {
        this.gson = new Gson();
    }

    @Override
    protected void readFromFile() throws Exception {
        object = (T) gson.fromJson(new FileReader(filePath),
                objectClass);
    }

    @Override
    protected void closeFile() {
        gson = null;
    }

}
