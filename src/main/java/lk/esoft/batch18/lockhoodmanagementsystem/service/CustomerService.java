package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCustomerDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCustomerSaveDTO;

public interface CustomerService {
    String addCustomer(RequestCustomerSaveDTO requestCustomerSaveDTO);

    PaginatedGetCustomerDTO getAllCustomers(int page, int size);
}
