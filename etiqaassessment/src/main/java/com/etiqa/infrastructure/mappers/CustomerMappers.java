package com.etiqa.infrastructure.mappers;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etiqa.infrastructure.constants.ResponseConstants;
import com.etiqa.infrastructure.exceptions.InvalidEntryException;
import com.etiqa.infrastructure.exceptions.NotNullException;
import com.etiqa.infrastructure.exceptions.RequiredFieldException;
import com.etiqa.infrastructure.exceptions.ResultNotFoundException;
import com.etiqa.infrastructure.entities.Customer;
import com.etiqa.infrastructure.dto.CustomerDto;

/**
 * 
 * @author Sakshi Doshi  CustomerMappers
 *
 */
public class CustomerMappers {

	private static final Logger logger = LoggerFactory.getLogger(CustomerMappers.class);

	/**
	 * @param customerList
	 * @return list of response dto for customer list
	 * @throws ResultNotFoundException mapping fetched entities to response dto
	 * @throws RequiredFieldException
	 * @throws InvalidEntryException
	 */
	public static List<CustomerDto> mapAllCustomers(List<Customer> customerList)
			throws ResultNotFoundException, RequiredFieldException, InvalidEntryException {

		logger.info("CustomerMappers called to map all customers ");

		List<CustomerDto> customerResponseList = new LinkedList<CustomerDto>();
		for (Customer customer : customerList) {
			CustomerDto dto = new CustomerDto();

			dto.setCustId(customer.getCustId());
			dto.setCustFirstName(customer.getCustFirstName());
			dto.setCustLastName(customer.getCustLastName());
			dto.setCustEmail(customer.getCustEmail());
			dto.setCustStatus(customer.getCustStatus());
			dto.setCustMobNo(customer.getCustMobNo());

			customerResponseList.add(dto);
		}

		logger.info("CustomerMappers execution done ");

		return customerResponseList;
	}

	/**
	 * @param customerDetails
	 * @return Customer
	 * @throws NotNullException
	 * @throws NotNullException
	 * @throws InvalidEntryException
	 */
	public static Customer convertRequestModelToDbModel(CustomerDto customerDetails, Customer customer)
			throws RequiredFieldException, NotNullException, InvalidEntryException {

		logger.info("CustomerMappers called to map all customers ");

		if (customerDetails != null) {

			if (customerDetails.getCustEmail() == null || customerDetails.getCustEmail().equals("")) {
				throw new RequiredFieldException("Customer Email" + ResponseConstants.MANDATE_FIELD);
			} else {
				customer.setCustEmail(customerDetails.getCustEmail());
			}
			if (customerDetails.getCustFirstName() == null || customerDetails.getCustFirstName().equals("")) {
				throw new RequiredFieldException("Customer First Name" + ResponseConstants.MANDATE_FIELD);
			} else {
				customer.setCustFirstName(customerDetails.getCustFirstName());
			}
			if (customerDetails.getCustLastName() == null || customerDetails.getCustLastName().equals("")) {
				throw new RequiredFieldException("Customer Last Name" + ResponseConstants.MANDATE_FIELD);
			} else {
				customer.setCustLastName(customerDetails.getCustLastName());
			}

			customer.setCustMobNo(customerDetails.getCustMobNo());
			customer.setCustStatus(customerDetails.getCustStatus());


		} else {
			throw new NotNullException(" Customer Details " + ResponseConstants.NOT_NULL_EXCEPTION);
		}

		logger.info("CustomerMappers execution done ");

		return customer;
	}

}
