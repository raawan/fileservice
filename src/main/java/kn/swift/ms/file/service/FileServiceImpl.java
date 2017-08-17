package kn.swift.ms.file.service;

import kn.swift.ms.file.domain.FileData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Service
public class FileServiceImpl {

    private final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final static String dirName = "datadir";

    @Transactional
    public String saveFileData(FileData fileData, String filename) {

        String  dirPath = System.getProperty("user.home") + "/" + dirName;
        File dir = new File(dirPath);

        if (!dir.exists()) {
            dir.mkdir();
        }
        //create file
        String fileLocation = dirPath + "/" +  filename;
        File file = new File(fileLocation);
        try {
            if (file.createNewFile()) {
                //Files.write(Paths.get(fileLocation), fileData.getData().getBytes(), StandardOpenOption.CREATE_NEW);
                BufferedWriter out = new BufferedWriter(new FileWriter(fileLocation));
                out.write(fileData.getData());
                out.close();
            } else {
                //file already exist
                fileLocation = fileLocation + new Date().getTime();
                BufferedWriter out = new BufferedWriter(new FileWriter(fileLocation));
                out.write(fileData.getData());
                out.close();
            }
        } catch (IOException e) {
            log.error("FILE IO ISSUE" + e);
        }
        return fileLocation;
    }
}
