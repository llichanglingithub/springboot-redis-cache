package com.seedyee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lcl
 * @createDate 2016年11月24日下午11:03:57
 *
 */
@Component
public class RedisDao {
	
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//	
////	@Resource(name = "stringRedisTemplate")
////	private ValueOperations<String, String> valOpsStr;
//	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//	
////	@Resource
////	private ValueOperations<String, Object> valOps;
//	/**
//	 * 存储字符串
//	 * @param key string类型的key
//	 * @param value String类型的value
//	 */
//	public void set(String key, String value) {
//		stringRedisTemplate.opsForValue().set(key, value);
//	}
//	
//	/**
//	 * 存储对象
//	 * @param key String类型的key
//	 * @param value Object类型的value
//	 */
//	public void set(String key, Object value) {
//		redisTemplate.opsForValue().set(key, value);
//	}
//	/**
//	 * 根据key获取字符串数据
//	 * @param key
//	 * @return
//	 */
//	public String getValue(String key) {
//		return stringRedisTemplate.opsForValue().get(key);
//	}
//	/**
//	 * 根据key获取对象
//	 * @param key
//	 * @return
//	 */
//	public Object getValueOfObject(String key) {
//		return redisTemplate.opsForValue().get(key);
//	}
//	/**
//	 * 根据key删除缓存信息
//	 * @param key
//	 */
//	public void delete(String key) {
//		if (hasCache(key)) {
//			redisTemplate.delete(key);
//		}
//	}
//	/**
//	 * 根据key判断缓存是否存在
//	 * @param key
//	 * @return
//	 */
//	public boolean hasCache(String key) {
//		return redisTemplate.hasKey(key);
//	}
}
