package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.AddProductSupplierDTO;
import com.cg.ecom.dto.ProductSupplierDTO;
import com.cg.ecom.entity.ProductSupplier;
import com.cg.ecom.exceptions.ProductSupplierNotAvailableException;
import com.cg.ecom.repository.ProductSupplierRepository;
import com.cg.ecom.service.ProductSupplierService;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {
	@Autowired
	private ProductSupplierRepository productSupplierRepository;

	
	@Override
	public ProductSupplierDTO addProductSupplier(AddProductSupplierDTO addProductSupplierDTO) {


		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setProductSupplierName(addProductSupplierDTO.getProductSupplierName());
		productSupplier.setEmailId(addProductSupplierDTO.getEmailId());
		productSupplier.setContactNo(addProductSupplierDTO.getContactNo());
        productSupplier.setLocation(addProductSupplierDTO.getLocation());
		
        ProductSupplier productSupplierave=productSupplierRepository.save(productSupplier);

        ProductSupplierDTO productSupplierDto = new ProductSupplierDTO();
        productSupplierDto.setProductSupplierId(productSupplierave.getProductSupplierId());
        productSupplierDto.setProductSupplierName(productSupplierave.getProductSupplierName());
        productSupplierDto.setContactNo(productSupplierave.getContactNo());
        productSupplierDto.setEmailId(productSupplierave.getEmailId());
        productSupplierDto.setLocation(productSupplierave.getLocation());

		return productSupplierDto;
	}

	
	
	@Override
	public ProductSupplierDTO updateProductSupplier(ProductSupplierDTO productSupplierDTO) {

		ProductSupplier productSupplier = new ProductSupplier();
//		User user=new User();
//		user.setUserId(productSupplierDTO.getUserId());
//		productSupplier.setUserId(user);
		productSupplier.setProductSupplierId(productSupplierDTO.getProductSupplierId());
		productSupplier.setProductSupplierName(productSupplierDTO.getProductSupplierName());
		productSupplier.setEmailId(productSupplierDTO.getEmailId());
		productSupplier.setContactNo(productSupplierDTO.getContactNo());
		productSupplier.setLocation(productSupplierDTO.getLocation());
		
		productSupplierRepository.save(productSupplier);
		return productSupplierDTO;
	}

	@Override
	public boolean deleteProductSupplier(ProductSupplierDTO productSupplierDTO) {

		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setProductSupplierId(productSupplierDTO.getProductSupplierId());
		productSupplierRepository.delete(productSupplier);
		return true;//write logic
	}

	@Override
	public ProductSupplierDTO getById(int id) {

		Optional<ProductSupplier> productSupplier = productSupplierRepository.findById(id);
		if (productSupplier.isPresent()) {
			ProductSupplierDTO dto = new ProductSupplierDTO();
			BeanUtils.copyProperties(productSupplier.get(), dto);
			return dto;
		}
		throw new ProductSupplierNotAvailableException("ProductSupplierNotAvailable not Available");
	}

	@Override
	public List<ProductSupplierDTO> findAll() {

		List<ProductSupplier> productSupplier = productSupplierRepository.findAll();
		List<ProductSupplierDTO> dtos = new ArrayList<>();
		for (ProductSupplier productSupplier1 : productSupplier) {
			ProductSupplierDTO dto = new ProductSupplierDTO();
			BeanUtils.copyProperties(productSupplier1, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
