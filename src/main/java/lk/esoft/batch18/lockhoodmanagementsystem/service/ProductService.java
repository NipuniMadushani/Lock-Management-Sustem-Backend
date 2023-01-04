package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    String addProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();
}
