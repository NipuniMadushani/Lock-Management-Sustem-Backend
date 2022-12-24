package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.CustomerDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.PlantDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Customer;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Plant;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    List<CustomerDTO> pageToList(Page<Customer> customer);
}
