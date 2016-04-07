package com.mengxiaotian.service;

import java.util.List;

import com.mengxiaotian.common.meta.BuyList;
import com.mengxiaotian.meta.Trx;

public interface TrxService extends BaseService<Trx, Integer> {

	public List<BuyList> getBuyList(Integer id);


	public boolean buy(Integer contentId, Integer id);

}