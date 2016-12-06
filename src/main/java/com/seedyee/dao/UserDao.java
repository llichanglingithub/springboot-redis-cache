package com.seedyee.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.seedyee.domain.User;

/**
 * @author lcl
 * @createDate 2016年11月21日下午5:19:01
 *
 */
@CacheConfig
public interface UserDao extends MongoRepository<User, String> {
	
	User findById(String id);

	User findByName(String name);


}
