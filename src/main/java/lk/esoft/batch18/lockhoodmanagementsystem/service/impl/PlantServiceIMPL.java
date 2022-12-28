package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetPlantDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestPlantSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Company;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Plant;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CompanyRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.PlantRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.PlantService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.CompanyMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.PlantMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class PlantServiceIMPL implements PlantService {

    @Autowired
    private PlantRepo plantRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlantMapper plantMapper;


    @Override
    public String addPlant(RequestPlantSaveDTO requestPlantSaveDTO) {
        Plant plant = modelMapper.map(requestPlantSaveDTO, Plant.class);
        if (!plantRepo.existsById(plant.getId())) {

            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            plant.setCreatedDate(date);
            plant.setUpdatedDate(date);

            plantRepo.save(plant);
            return "saved " + plant.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public PaginatedGetPlantDTO getAllPlants(int page, int size) {
        page = 0;
        size = 1000;
        Page<Plant> plants = plantRepo.findAll(PageRequest.of(page,size));
        if(plants.getSize()<1){
            throw new NotFoundException("no plants currently available");
        }
        return new PaginatedGetPlantDTO(
                plantMapper.pageToList(plants),
                plantRepo.countAllBy()
        );
    }
}
