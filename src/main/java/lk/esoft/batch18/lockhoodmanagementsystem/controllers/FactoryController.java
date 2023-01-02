package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCustomerSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CustomerService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.FactoryService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factory")
@CrossOrigin
public class FactoryController {
    @Autowired
    private FactoryService factoryService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveFactory(@RequestBody FactoryDTO factoryDTO) {
        String message = factoryService.addFactory(factoryDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-factory")
    public ResponseEntity<StandardResponse> getAllFactories(){
        List<FactoryDTO> allFacts = factoryService.getAllfacts();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allFacts),
                HttpStatus.OK
        );

    }

}
