package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.SupervisorDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Supervisor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupervisorMapper {
    Supervisor requestDtoToEntity(SupervisorDTO departmentDTO);
}
