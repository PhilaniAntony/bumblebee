package app.bumblebee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private Properties properties = new Properties();

    PropertyLoader() {
        loadBeeProperties();
    }

    public void loadBeeProperties() {
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader("bee.properties"));

            try{
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties files");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found.");
        }
    }

    public Properties getProperties() {
        return this.properties;
    }
}