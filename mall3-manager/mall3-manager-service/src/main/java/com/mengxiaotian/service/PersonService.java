package com.mengxiaotian.service;

import com.mengxiaotian.common.meta.User;
import com.mengxiaotian.meta.Person;

public interface PersonService extends BaseService<Person, Integer> {

	boolean login(String userName, String password);

	User getUser(String userName);

}