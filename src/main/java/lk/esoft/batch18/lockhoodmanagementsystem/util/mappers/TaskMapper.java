package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.TaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestPlantSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Plant;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task dtoToEntity(TaskDTO taskDTO);
}
