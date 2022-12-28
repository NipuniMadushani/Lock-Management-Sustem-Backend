package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCompanySaveDTO;

public interface CompanyService {


    String addCompany(RequestCompanySaveDTO requestCompanySaveDTO);

    PaginatedGetCompanyDTO getAllCompanies(int page, int size);
}
