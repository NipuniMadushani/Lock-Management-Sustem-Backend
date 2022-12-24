package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetPlantDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestPlantSaveDTO;

public interface PlantService {
    String addPlant(RequestPlantSaveDTO requestPlantSaveDTO);

    PaginatedGetPlantDTO getAllPlants(int page, int size);
}
