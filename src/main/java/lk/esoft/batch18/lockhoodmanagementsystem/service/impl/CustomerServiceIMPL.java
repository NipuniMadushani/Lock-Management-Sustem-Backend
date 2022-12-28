package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCustomerDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCustomerSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Company;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Customer;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CompanyRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CustomerRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CustomerService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.CompanyMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CompanyRepo companyRepo;
    @Override
    public String addCustomer(RequestCustomerSaveDTO requestCustomerSaveDTO) {
        Customer customer = modelMapper.map(requestCustomerSaveDTO, Customer.class);
        customer.setCompany(companyRepo.findById(requestCustomerSaveDTO.getCompanyId()).get());
        if (!customerRepo.existsById(customer.getId())) {

            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            customer.setCreatedDate(date);
            customer.setUpdatedDate(date);

            customerRepo.save(customer);
            return "saved " + customer.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public PaginatedGetCustomerDTO getAllCustomers(int page, int size) {
        page = 0;
        size = 1000;
        Page<Customer> customers = customerRepo.findAll(PageRequest.of(page,size));
        if(customers.getSize()<1){
            throw new NotFoundException("no customers currently available");
        }
        return new PaginatedGetCustomerDTO(
                customerMapper.pageToList(customers),
                customerRepo.countAllBy()
        );
    }
}
