package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.IncomeDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.ProductDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Income;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
    Income requestDtoToEntity(IncomeDTO incomeDTO);
}
