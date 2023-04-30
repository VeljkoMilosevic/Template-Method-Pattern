/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import desing.patterns.templatemethod.domain.FileHandlingException;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @param <T>
 * @author Veljko
 */
public class JSONWriter<T> extends AbstractWriter<T> {

    private Gson gson;
    private FileWriter fileWriter;
    private static final String JSON_EXTENSION = ".json";

    @Override
    protected void initializeFileWriter() throws FileHandlingException {
        this.gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").setPrettyPrinting().create();
        try {
            fileWriter = new FileWriter(filePath);
        } catch (final IOException ioException) {
            throw new FileHandlingException("Exception during init stream to file on path:%s" + filePath, ioException);
        }
    }

    @Override
    protected void setFileExtension() {
        filePath += JSON_EXTENSION;
    }

    @Override
    protected void writeToFile() {
        gson.toJson(object, fileWriter);
    }

    @Override
    protected void closeFile() throws FileHandlingException {
        try {
            if (fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
                fileWriter = null;
            }
        } catch (final IOException ioException) {
            throw new FileHandlingException("Exception during closing file on path:%s" + filePath, ioException);
        }
    }

}
