package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.ProductDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.DepartmentService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.ProductService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveDepartment(@RequestBody ProductDTO productDTO) {
        String message = productService.addProduct(productDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-products")
    public ResponseEntity<StandardResponse> getAllProducts(){
        List<ProductDTO> allProduct = productService.getAllProducts();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allProduct),
                HttpStatus.OK
        );

    }

}
