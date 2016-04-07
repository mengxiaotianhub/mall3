package com.mengxiaotian.service;

import java.util.List;

public interface BaseService<T, ID> {
	public void setBaseMapper();

	public int deleteByPrimaryKey(ID id);
	
	public int delete(T record);

	public int insert(T record);

	public int insertSelective(T record);

	public T selectByPrimaryKey(ID id);
	
	public T selectOne(T record);
	
	public List<T> select(T record);
	
	public List<T> selectAll(T record);
	
	public int selectCout(T record);

	public int updateByPrimaryKey(T record);
	
	public int updateByPrimaryKeySelective(T record);

}