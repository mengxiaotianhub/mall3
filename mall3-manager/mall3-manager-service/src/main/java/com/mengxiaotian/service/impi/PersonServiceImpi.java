package com.mengxiaotian.service.impi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengxiaotian.common.meta.User;
import com.mengxiaotian.dao.PersonMapper;
import com.mengxiaotian.meta.Person;
import com.mengxiaotian.service.PersonService;

@Service("personService")
public class PersonServiceImpi  extends BaseServiceImpi<Person, Integer>  implements PersonService{

	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		this.baseMapper=personMapper;
	}

	@Override
	public boolean login(String userName, String password) {
		Person record= new Person();
		record.setUserName(userName);
		record.setPassword(password);
		if (personMapper.selectOne(record)== null) {
			return false;
		} else {
			return true;

		}
}

	@Override
	public User getUser(String userName) {
		Person record= new Person();
		record.setUserName(userName);
		User user = new User();
		Person person = selectOne(record);
		user.setUsername(person.getNickName());
		user.setUsertype(person.getUserType());
		user.setId(person.getId());
		return user;
	}
}
