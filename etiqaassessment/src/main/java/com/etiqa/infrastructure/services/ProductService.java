package com.etiqa.infrastructure.services;

import com.etiqa.infrastructure.dto.PageableResponse;
import com.etiqa.infrastructure.dto.ProductDto;

public interface ProductService {
	
	public PageableResponse getAllProduct();
	
	public PageableResponse deleteById(Long id);
	
	public PageableResponse addProduct(ProductDto roleDetailDto);
	
	public PageableResponse updateProduct(ProductDto roleDetailDto);	
	
}

