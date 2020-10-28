package com.codenotfound.primefaces.service;

import com.codenotfound.primefaces.exception.FileStorageException;
import com.codenotfound.primefaces.model.DBF;
import com.codenotfound.primefaces.model.DBFile;
import com.codenotfound.primefaces.repository.DBFRepository;
import com.codenotfound.primefaces.repository.DBFileRepository;
import com.codenotfound.primefaces.view.AccountView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;
    
    @Autowired
    private DBFRepository dbFRepository;

    public DBFile storeFile(MultipartFile file,String p) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            DBFile current = dbFileRepository.save(dbFile);
    		DBF File = new DBF(current.getId(), fileName, file.getContentType(),p);
    		dbFRepository.save(File);
    		return current;
            
            
            
            
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findOne(fileId);
    }
}
