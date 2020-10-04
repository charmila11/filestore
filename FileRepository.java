package com.example.demo.filerepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.file.Documents;

@Repository
public interface FileRepository extends JpaRepository<Documents, String> {
	
}
