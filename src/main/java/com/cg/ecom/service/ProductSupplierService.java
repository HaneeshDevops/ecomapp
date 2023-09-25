package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.AddProductSupplierDTO;
import com.cg.ecom.dto.ProductSupplierDTO;

public interface ProductSupplierService {

	public ProductSupplierDTO addProductSupplier(AddProductSupplierDTO addProductSupplierDTO);

	public ProductSupplierDTO updateProductSupplier(ProductSupplierDTO productSupplierDTO);

	public boolean deleteProductSupplier(ProductSupplierDTO productSupplierDTO);

	public ProductSupplierDTO getById(int id);

	public List<ProductSupplierDTO> findAll();
}
