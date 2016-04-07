package com.mengxiaotian.service.impi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengxiaotian.common.meta.BuyList;
import com.mengxiaotian.dao.ContentMapper;
import com.mengxiaotian.dao.TrxMapper;
import com.mengxiaotian.meta.Trx;
import com.mengxiaotian.service.TrxService;

@Service("trxService")
public class TrxServiceImpi  extends BaseServiceImpi<Trx, Integer>  implements TrxService{

	@Autowired
	private TrxMapper trxMapper;
	
	@Autowired
	private ContentMapper contentMapper;
	
	@Autowired
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		this.baseMapper=trxMapper;
	}

	@Override
	public List<BuyList> getBuyList(Integer id) {
		return trxMapper.getBuyList(id);
	}

	@Override
	public boolean buy(Integer contentId, Integer id) {
		Trx trx = new Trx();
		trx.setPersonId(id);
		trx.setContentId(contentId);
		trx.setBuyPrice(contentMapper.selectByPrimaryKey(contentId).getPrice());
		trx.setBuyTime((new Date()).getTime());
		trxMapper.insertSelective(trx);
		return true;
	}
}

