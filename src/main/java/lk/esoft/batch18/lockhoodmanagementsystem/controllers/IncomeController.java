package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.IncomeDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.ProductDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.IncomeService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.ProductService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/income")
@CrossOrigin
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveIncome(@RequestBody IncomeDTO incomeDTO) {
        String message = incomeService.addIncome(incomeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-income")
    public ResponseEntity<StandardResponse> getAllIncomes(){
        List<IncomeDTO> income = incomeService.getAllIncome();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",income),
                HttpStatus.OK
        );

    }
}
