/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import desing.patterns.templatemethod.domain.FileHandlingException;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @param <T>
 * @author Veljko
 */
public class JSONReader<T> extends AbstractReader<T> {

    private Gson gson;

    @Override
    protected void setPathFileExtension() {
        filePath += ".json";
    }

    @Override
    protected void initializeFileReader() {
        this.gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    }

    @Override
    protected void readFromFile() throws FileHandlingException {
        try {
            object = gson.fromJson(new FileReader(filePath),
                    objectClass);
        } catch (final FileNotFoundException e) {
            throw new FileHandlingException("Exception during reading file on path:" + filePath, e);
        }
    }

    @Override
    protected void closeFile() {
        gson = null;
    }

}
