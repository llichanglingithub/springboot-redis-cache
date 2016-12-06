package com.seedyee.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seedyee.domain.User;
import com.seedyee.service.UserService;

/**
 * @author lcl
 * @createDate 2016年11月21日下午5:39:43
 *
 */
@RestController
public class UserEndPiont {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object createUser(@ModelAttribute(name = "user") User user) {
		
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "/get/{id}/", method = RequestMethod.GET)
	public Object getUserInfo(@PathVariable(name = "id", required = true)String id) {
		
		return userService.getUserInfo(id);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object updateUserInfo(User user) {
		
		return userService.updateUserInfo(user);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Object deleteUser(@RequestParam(name = "id", required = true)String id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping(value = "/test-cache", method = RequestMethod.POST)
	@Cacheable(cacheNames = "users", key = "#id")
	public Object testCache(@RequestParam(name = "id", required = true) String id){
		return "test";
	}
}
