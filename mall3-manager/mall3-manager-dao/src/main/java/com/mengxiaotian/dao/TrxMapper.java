package com.mengxiaotian.dao;

import java.util.List;

import com.mengxiaotian.common.meta.BuyList;
import com.mengxiaotian.meta.Trx;
import tk.mybatis.mapper.common.Mapper;

public interface TrxMapper extends Mapper<Trx> {
	public List<BuyList> getBuyList(Integer userId);
}