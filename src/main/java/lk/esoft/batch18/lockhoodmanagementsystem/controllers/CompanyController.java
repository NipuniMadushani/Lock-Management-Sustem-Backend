package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCompanySaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CompanyService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveCompany(@RequestBody RequestCompanySaveDTO requestCompanySaveDTO) {
        String message = companyService.addCompany(requestCompanySaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-company"}
    )
    public ResponseEntity<StandardResponse> getAllCompanies() {
        int page = 0;
        int size = 1000;
        PaginatedGetCompanyDTO paginatedGetCompanyDTO = companyService.getAllCompanies(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", paginatedGetCompanyDTO),
                HttpStatus.OK
        );
    }
}
