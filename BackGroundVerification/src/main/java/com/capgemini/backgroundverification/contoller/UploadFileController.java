package com.capgemini.backgroundverification.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.backgroundverification.dao.FileRepository;
import com.capgemini.backgroundverification.entity.FileModel;
import com.capgemini.backgroundverification.entity.Logindata;
import com.capgemini.backgroundverification.entity.Verification;
import com.capgemini.backgroundverification.exception.IdNotFoundException;
import com.capgemini.backgroundverification.service.EmployeeService;


@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {
	
	@Autowired
	FileRepository fileRepository;
	EmployeeService serviceobj;
 
    /*
     * MultipartFile Upload
     */
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
    	try {
    		// save file to PostgreSQL
	    	FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(),file.getBytes());
	    	fileRepository.save(filemode);
	    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }
}