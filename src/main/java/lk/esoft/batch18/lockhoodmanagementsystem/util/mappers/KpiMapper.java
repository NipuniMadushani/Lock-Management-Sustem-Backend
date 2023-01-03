package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.KpiDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Factory;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Kpi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KpiMapper {
    Kpi requestDtoToEntity(KpiDTO kpiDto);
}
