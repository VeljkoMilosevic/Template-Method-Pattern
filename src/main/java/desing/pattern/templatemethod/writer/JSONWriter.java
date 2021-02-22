/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;

/**
 *
 * @author Veljko
 * @param <T>
 */
public class JSONWriter<T> extends AbstractWriter<T> {

    private Gson gson;
    private FileWriter fileWriter;
    private static final String JSON_EXTENSION = ".json";

    @Override
    protected void initializeFileWriter() throws Exception {
        this.gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").setPrettyPrinting().create();
        fileWriter = new FileWriter(filePath);
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
    protected void closeFile() throws Exception {
        if (fileWriter != null) {
            fileWriter.flush();
            fileWriter.close();
            fileWriter = null;
        }
    }

}
