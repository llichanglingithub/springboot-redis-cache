package com.seedyee.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.seedyee.dao.EmailDao;
import com.seedyee.dao.RedisDao;
import com.seedyee.dao.UserDao;
import com.seedyee.domain.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lcl
 * @createDate 2016年11月21日下午5:30:23
 *
 */
@Service
public class UserService {
	
	@Autowired
	private CacheManager cacheManager;
	
//	@Autowired
//	private RedisDao redis;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmailDao emailDao;
	
	
	//@Cacheable(cacheNames = {"users"}, key= "#user.id")
	public Object createUser(User user) {
		
		User createUser = null;
		createUser = userDao.save(user);
		return createUser;
	}
	@Cacheable(cacheNames = {"users"}, key = "'user:' + #id" )
	public Object getUserInfo(String id) {
		User user = null;
		user = userDao.findById(id);
		Collection<String> cacheNames = cacheManager.getCacheNames();
		for (String string : cacheNames) {
			System.out.println(string);
			System.out.println(cacheManager.getCache(string));
		}
		System.out.println("--------------进来说明没有使用缓存-------------------");
		//使用StringTemplate的OpsValue插入一条数据，测试value是否会乱码
		//redis.set("111111111111", "这是一条测试是否会出现乱码的数据a");
		return user;
	}
	//@CacheEvict(cacheNames = {"users"}, key = "#user.id")
	public Object updateUserInfo(User user) {
		User formUser = userDao.findById(user.getId());
		if (user.getName() != null && formUser != null) {
			formUser.setName(user.getName());

			//修改成功删除缓存中的数据
			//redis.delete(formUser.getId());
			System.out.println("---------缓存已经删除------------");
			return userDao.save(formUser);
		}
		return "修改出现异常";
	}
	@CacheEvict(cacheNames = {"users"})
	public Object deleteUser(String id) {
		userDao.delete(id);
		//删除成功删除缓存中的数据
		//redis.delete(id);
		return "ok";
	}
	
	//@Cacheable(cacheNames = "users", key = "#id")
	public Object testCache(String id) {
		User user = new User();
		user.setId(id);
		user.setRelName("zhangshan");
		user.setAge(25);
		return user;
	}
}
