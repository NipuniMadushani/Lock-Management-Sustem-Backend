package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Factory;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Workshop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkshopMapper {
    Workshop requestDtoToEntity(WorkshopDTO workshopDTO);
}
