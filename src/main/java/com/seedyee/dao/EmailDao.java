package com.seedyee.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seedyee.domain.Email;

/**
 * @author lcl
 * @createDate 2016年11月21日下午5:22:05
 *
 */
public interface EmailDao extends MongoRepository<Email, String>{
	
	Email findById(String id);
	
	Email findByEmail(String email);
}
