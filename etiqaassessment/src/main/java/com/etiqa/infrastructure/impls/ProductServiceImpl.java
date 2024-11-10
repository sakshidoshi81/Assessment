package com.etiqa.infrastructure.impls;

import java.sql.Timestamp;
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
import com.etiqa.infrastructure.exceptions.NotNullException;
import com.etiqa.infrastructure.exceptions.ResultNotFoundException;
import com.etiqa.infrastructure.mappers.ProductListMapper;
import com.etiqa.infrastructure.entities.Product;
import com.etiqa.infrastructure.dto.PageableResponse;
import com.etiqa.infrastructure.dto.ProductDto;
import com.etiqa.infrastructure.services.ProductService;
import com.etiqa.infrastructure.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepository;

	public Page<Product> get() {

		logger.info("Product 'GET service; called");
		Pageable pageable = Pageable.unpaged();


		logger.info("Product  'get service' METHOD called");

		return productRepository.findAll(pageable);
	}

	@Override
	public PageableResponse getAllProduct() {

		logger.info("Product 'GET service'  getAllProduct METHOD called");

		try {

			Page<Product> products = get();

			List<ProductDto> productResponseList = ProductListMapper.mapAllProduct(products.get().toList());

			logger.info("Product 'GET service' returnig productResponseList",
					productResponseList.size());

			return new PageableResponse(productResponseList, ResponseConstants.OCCURED_SUCCESS, ResponseConstants.SUCCESS_MESSAGE);

		} catch (Exception e) {

			logger.error("Product 'GET service'  exception occured :", e);

			return new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					ResponseConstants.ERROR_MESSAGE);

		}

	}

	@Override
	public PageableResponse deleteById(Long id) {

		logger.info("Product 'delete service' called, product id : ", id);

		try {
			productRepository.deleteById(id);

			logger.info("Product 'delete service'  CALLED AND EXECUTED", id);

			PageableResponse response = new PageableResponse( null, ResponseConstants.OCCURED_SUCCESS,
					ResponseConstants.SUCCESS_MESSAGE);
			return response;
		} catch (Exception e) {

			logger.error("Product 'delete service' got exception : ", e);

			return new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					ResponseConstants.ERROR_MESSAGE);

		}
	}

	@Override
	public PageableResponse addProduct(ProductDto productDetailDto) {

		logger.info("Product 'add service' called  ", productDetailDto);
		try {
			Optional<Product> products = productRepository.findByProductName(productDetailDto.getProductName());

			if (products.isPresent()) {
				throw new DuplicateEntryException(ResponseConstants.DUPLICATE_PRODUCT_NAME);
			}
			logger.info("Product 'add service' method called {} ", productDetailDto);

			Product product = ProductListMapper.convertRequestModelToDbModel(productDetailDto);
			Product productObj = productRepository.save(product);

			logger.info("Product 'add service' execution done {} ", productObj);

			PageableResponse pageableResponse = new PageableResponse( productObj,
					ResponseConstants.OCCURED_SUCCESS, ResponseConstants.SUCCESS_MESSAGE);
			return pageableResponse;

		} catch (Exception e) {

			logger.error("Product 'add service' got exception : ", e);

			PageableResponse pageableResponse = new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					e.getMessage());
			return pageableResponse;
		}
	}

	@Override
	public PageableResponse updateProduct(ProductDto productDetailDto) {

		logger.info("Product 'update service' method called {} ", productDetailDto);

		try {

			if (productDetailDto.getProductId() == null) {
				throw new NotNullException("Product Id " + ResponseConstants.MANDATE_FIELD);
			}

			logger.info("Product 'update service' called {} ");

			Optional<Product> productPersist = productRepository.findById(productDetailDto.getProductId());
			if (productPersist.isEmpty()) {
				throw new ResultNotFoundException("Product " + ResponseConstants.RESULT_NOT_FOUND);
			}

			Product product = productPersist.get();

			product.setProductName(productDetailDto.getProductName());
			product.setProductPrice(productDetailDto.getProductPrice());
			product.setProductQuantity(productDetailDto.getProductQuantity());
			product.setProductTitle(productDetailDto.getProductTitle());
			product.setStatus(productDetailDto.getStatus());

			logger.info("Product 'update service'  query called {} ");

			Product productObj = productRepository.save(product);

			logger.info("Product 'update service' excution done ", productObj);

			PageableResponse pageableResponse = new PageableResponse( productObj,
					ResponseConstants.OCCURED_SUCCESS, ResponseConstants.SUCCESS_MESSAGE);
			return pageableResponse;

		} catch (Exception e) {

			logger.error("Product 'update service' got exception ", e);

			e.printStackTrace();
			PageableResponse pageableResponse = new PageableResponse( null, ResponseConstants.OCCURED_ERROR,
					e.getMessage());
			return pageableResponse;
		}
	}

}
