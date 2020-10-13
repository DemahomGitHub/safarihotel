package com.safarihotel.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReaderHelper {

    public static String getFileContent(String fileLocation) throws IOException {
        File location = new ClassPathResource(fileLocation).getFile();
        return new String(Files.readAllBytes(location.toPath()));
    }
}
