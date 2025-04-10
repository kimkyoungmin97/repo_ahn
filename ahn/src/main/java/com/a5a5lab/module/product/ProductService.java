package com.a5a5lab.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public int selectOneCount(ProductVo vo) {
		return productDao.selectOneCount(vo);
	}
	
	//상품 목록 리스트 뿌리기
	public List<ProductDto> selectList(ProductVo vo){
		return productDao.selectList(vo);
	}
	
}
