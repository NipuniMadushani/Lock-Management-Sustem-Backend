package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.CompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.PlantDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestPlantSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Company;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Plant;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantMapper {
    List<PlantDTO> pageToList(Page<Plant> items);
    Plant dtoToEntity(RequestPlantSaveDTO requestPlantSaveDTO);
}
