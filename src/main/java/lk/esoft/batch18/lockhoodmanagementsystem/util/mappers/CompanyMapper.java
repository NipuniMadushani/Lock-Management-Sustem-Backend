package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.CompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Company;
import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    List<CompanyDTO> pageToList(Page<Company> items);
}
