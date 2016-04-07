package com.mengxiaotian.service;

import java.util.List;

import com.mengxiaotian.common.meta.Product;
import com.mengxiaotian.common.meta.ProductList;
import com.mengxiaotian.meta.Content;

public interface ContentService extends BaseService<Content, Integer> {

	public List<ProductList> getProductList(Integer userId) throws Throwable;

	public Product getProduct(Integer productId, Integer userId) throws Exception;

}