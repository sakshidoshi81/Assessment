package com.etiqa.infrastructure.impls;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.etiqa.infrastructure.constants.ResponseConstants;
import com.etiqa.infrastructure.exceptions.DuplicateEntryException;
import com.etiqa.infrastructure.exceptions.RequiredFieldException;
import com.etiqa.infrastructure.exceptions.ResultNotFoundException;
import com.etiqa.infrastructure.mappers.CustomerMappers;
import com.etiqa.infrastructure.entities.Customer;
import com.etiqa.infrastructure.services.CustomerService;
import com.etiqa.infrastructure.dto.CustomerDto;
import com.etiqa.infrastructure.repositories.CustomerRepository;
import com.etiqa.infrastructure.dto.PageableResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public PageableResponse addCustomer(CustomerDto custDto) {

		logger.info("Customer 'create service' addCustomer() called", custDto);

		try {
			Optional<Customer> customer = customerRepository.findByCustEmail(custDto.getCustEmail());
			if (!customer.isEmpty()) {
				throw new DuplicateEntryException(ResponseConstants.DUPLICATE_PRODUCT_NAME);
			}
			Customer customerObj = CustomerMappers.convertRequestModelToDbModel(custDto, new Customer());
			Customer customerPersist = customerRepository.save(customerObj);

			logger.info("Customer 'create service' excution done", customerPersist);

			PageableResponse pageableResponse = new PageableResponse( customerPersist,
					ResponseConstants.OCCURED_SUCCESS, ResponseConstants.SUCCESS_MESSAGE);
			return pageableResponse;

		} catch (Exception e) {

			logger.error("Customer 'create service' got  exception done", e);

			PageableResponse pageableResponse = new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					e.getMessage());
			return pageableResponse;
		}
	}

	@Override
	public PageableResponse updateCustomer(CustomerDto custDto) {
		// TODO Auto-generated method stub

		logger.info("Customer 'update service' called ", custDto);

		try {

			if (custDto.getCustId() == null) {
				throw new RequiredFieldException(" Customer Id " + ResponseConstants.MANDATE_FIELD);
			}

			Optional<Customer> customer = customerRepository.findById(custDto.getCustId());

			if (customer.isEmpty()) {
				throw new ResultNotFoundException("Customer Id " + ResponseConstants.RESULT_NOT_FOUND);
			}

			Customer customerObj = customer.get();

			customerObj = CustomerMappers.convertRequestModelToDbModel(custDto, customerObj);

			Customer CustomerPersist = customerRepository.save(customerObj);

			logger.info("Customer 'update service' excution done ", custDto);

			PageableResponse pageableResponse = new PageableResponse( CustomerPersist,
					ResponseConstants.OCCURED_SUCCESS, ResponseConstants.SUCCESS_MESSAGE);
			return pageableResponse;

		} catch (Exception e) {

			logger.error("Customer 'update service' got  exception done ", e);

			PageableResponse pageableResponse = new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					e.getMessage());
			return pageableResponse;
		}
	}


	@Override
	public PageableResponse getAllCustomer() {

		try {

			logger.info("Customer 'get' service called");

			Pageable pageable = Pageable.unpaged();

			logger.info("Customer 'get service' - findAll query and mapper methods  called");

			Page<Customer> customersList = customerRepository.findAll(pageable);

			List<CustomerDto> customerDtos = CustomerMappers.mapAllCustomers(customersList.get().toList());

			logger.info("Customer 'get service' excutiopn done", customerDtos);

			PageableResponse pageableResponse = new PageableResponse( customerDtos,
					ResponseConstants.OCCURED_SUCCESS, ResponseConstants.SUCCESS_MESSAGE);
			return pageableResponse;

		} catch (Exception ex) {

			logger.error("Customer 'get service' got exception", ex);

			PageableResponse pageableResponse = new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					ex.getMessage());
			return pageableResponse;
		}

	}

	@Override
	public PageableResponse deleteById(Long id) {

		logger.info("Customer 'delete service' called", id);

		try {
			customerRepository.deleteById(id);

			logger.info("Customer 'delete service' excution done ", id);

			PageableResponse pageableResponse = new PageableResponse( id, ResponseConstants.OCCURED_SUCCESS,
					ResponseConstants.SUCCESS_MESSAGE);
			return pageableResponse;
		} catch (Exception e) {

			logger.error("Customer 'delete service' got exception ", e);

			PageableResponse pageableResponse = new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					e.getMessage());
			return pageableResponse;
		}
	}


}
