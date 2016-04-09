package com.mengxiaotian.service.impi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengxiaotian.common.meta.Product;
import com.mengxiaotian.common.meta.ProductList;
import com.mengxiaotian.dao.ContentMapper;
import com.mengxiaotian.dao.TrxMapper;
import com.mengxiaotian.meta.Content;
import com.mengxiaotian.meta.Trx;
import com.mengxiaotian.service.ContentService;
import com.mengxiaotian.util.CopyUtil;

@Service("contentService")
public class ContentServiceImpi  extends BaseServiceImpi<Content, Integer>  implements ContentService{

	@Autowired
	private ContentMapper contentMapper;
	

	@Autowired
	private TrxMapper trxMapper;
	
	@Autowired
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		this.baseMapper=contentMapper;
	}

	@Override
	public List<ProductList> getProductList(Integer userId) throws Exception{
		List<ProductList> productll = new ArrayList<ProductList>();
		Trx record = new Trx();
		record.setPersonId(userId);
		List<Trx> trxList = trxMapper.select(record);
		for(Content content : contentMapper.selectAll()){
			ProductList productl = new ProductList();
			CopyUtil.Copy(content, productl);
			if(userId!=null){
				for(Trx trx:trxList){
					if(trx.getContentId()==productl.getId()){
						productl.setBuy(true);
					}
				}
			}
			productll.add(productl);
		}
		
		return productll;
	}

	@Override
	public Product getProduct(Integer productId, Integer userId) throws Exception {
		Product product = new Product();
		Trx record = new Trx();
		CopyUtil.Copy(contentMapper.selectByPrimaryKey(productId), product);
		record.setPersonId(userId);
		record.setContentId(productId);
		List<Trx> trx =trxMapper.select(record);
		if(trx.size()!=0){
			product.setBuyPrice(trx.get(0).getBuyPrice());
			product.setBuy(true);
		}
		return product;
	}

	@Override
	public List<Content> getAllProductList() {
		// TODO Auto-generated method stub
		return contentMapper.selectAll();
	}



}

