package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Factory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactoryMapper {
    Factory requestDtoToEntity(FactoryDTO factoryDTO);
}
