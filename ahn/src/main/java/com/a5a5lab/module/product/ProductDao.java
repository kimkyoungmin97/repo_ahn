package com.a5a5lab.module.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
	
	public int selectOneCount(ProductVo vo);
	//상품 목록 리스트 뿌리기
	public List <ProductDto> selectList(ProductVo vo);
	//신발 정보 가져오기
	public ProductDto selectOne(ProductDto productDto);
	
	public int uelete(List<Long> deleteIds);
}
