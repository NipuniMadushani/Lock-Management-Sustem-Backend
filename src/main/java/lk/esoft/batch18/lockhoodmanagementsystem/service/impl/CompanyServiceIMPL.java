package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCompanySaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Company;
import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.paginated.PaginatedUsers;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CompanyRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CompanyService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.CompanyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.openmbean.KeyAlreadyExistsException;
import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CompanyServiceIMPL implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public String addCompany(RequestCompanySaveDTO requestCompanySaveDTO) {
        Company company = modelMapper.map(requestCompanySaveDTO, Company.class);
        if (!companyRepo.existsById(company.getId())) {

            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            company.setCreatedDate(date);
            company.setUpdatedDate(date);

            companyRepo.save(company);
            return "saved " + company.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public PaginatedGetCompanyDTO getAllCompanies(int page, int size) {
        page = 0;
        size = 1000;
        Page<Company> companies = companyRepo.findAll(PageRequest.of(page,size));
        if(companies.getSize()<1){
            throw new NotFoundException("no companies currently available");
        }
        return new PaginatedGetCompanyDTO(
                companyMapper.pageToList(companies),
                companyRepo.countAllBy()
        );
    }


}
