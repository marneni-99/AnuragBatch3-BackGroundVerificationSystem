package com.capgemini.backgroundverification.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.backgroundverification.entity.*;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long>{	
	public FileModel findByName(String name);
	}