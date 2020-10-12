package com.safarihotel.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class FileHelper {
    public static String getFileContent(String location) {
        String fileContent = "";
        try {
            File myFile = new ClassPathResource(location).getFile();
            fileContent = new String(Files.readAllBytes(myFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
