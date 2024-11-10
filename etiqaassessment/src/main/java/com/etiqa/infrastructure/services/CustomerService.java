package com.etiqa.infrastructure.services;

import com.etiqa.infrastructure.dto.PageableResponse;
import com.etiqa.infrastructure.dto.CustomerDto;

public interface CustomerService {
	
	public PageableResponse getAllCustomer();
	
	public PageableResponse deleteById(Long id);
	
	public PageableResponse addCustomer(CustomerDto custDto);
	
	public PageableResponse updateCustomer(CustomerDto custDto);	
	
}