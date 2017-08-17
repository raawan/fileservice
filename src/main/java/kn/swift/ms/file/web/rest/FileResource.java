package kn.swift.ms.file.web.rest;

import kn.swift.ms.file.domain.FileData;
import kn.swift.ms.file.service.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api")
public class FileResource {

    private final Logger log = LoggerFactory.getLogger(FileResource.class);

    @Autowired
    private FileServiceImpl fileService;

    @PostMapping("/{filename}")
    public String storeDataInFile(@Valid @RequestBody FileData fileData, @PathVariable String filename) {
        String fileLocation = "";
       // return filename + ":" + fileData.getData();
        return fileService.saveFileData(fileData,filename);
    }

}
