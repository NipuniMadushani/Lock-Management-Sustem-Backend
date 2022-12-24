package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCustomerDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCompanySaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCustomerSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CompanyService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CustomerService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody RequestCustomerSaveDTO requestCustomerSaveDTO) {
        String message = customerService.addCustomer(requestCustomerSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-customer"},
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllCustomers(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size

    ) {
        PaginatedGetCustomerDTO paginatedGetCustomerDTO = customerService.getAllCustomers(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", paginatedGetCustomerDTO),
                HttpStatus.OK
        );
    }
}
