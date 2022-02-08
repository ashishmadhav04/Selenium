package Utilities;

import java.io.*;
import java.util.Properties;

public class ReadingPropertyFile {
    public static String ReadingPropertiesFile(String sProperty) throws IOException {
        try {
            String sResult = "";
            String sPropertyFile = "resources/application.properties";
            Properties prop = new Properties();
            InputStream iFile = new FileInputStream(sPropertyFile);
            prop.load(iFile);

            sResult = prop.getProperty(sProperty);

            return sResult;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }
    }

    public static void WritingPropertiesFile() throws FileNotFoundException {
        try {
            String sResult = "";
            String sPropertyFile = "resources/application.properties";
            Properties prop = new Properties();
            OutputStream iFile = new FileOutputStream(sPropertyFile);
            prop.setProperty("test", "testvalue");
            prop.store(iFile, null);

        }
        catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

}
