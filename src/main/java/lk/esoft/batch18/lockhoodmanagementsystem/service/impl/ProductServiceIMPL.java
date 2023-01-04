package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.ProductDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Product;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Workshop;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.PlantRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.ProductRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.ProductService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.PlantMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.ProductMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public String addProduct(ProductDTO productDTO) {
        Product product = productMapper.requestDtoToEntity(productDTO);
        if (!productRepo.existsById(product.getId())) {
            productRepo.save(product);
            return "saved " + product.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        if (products != null) {
            List<ProductDTO> product = modelMapper.
                    map(products, new TypeToken<List<ProductDTO>>() {
                    }.getType());
            return product;
        } else {
            throw new NotFoundException("No Data Found");
        }
    }
}
