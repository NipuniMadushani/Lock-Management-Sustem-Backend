package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Factory;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Workshop;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.WorkshopRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.WorkshopService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.WorkshopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;

@Service
public class WorkshopServiceIMPL implements WorkshopService {
    @Autowired
    private WorkshopRepo workshopRepo;

    @Autowired
    private WorkshopMapper workshopMapper;

    @Override
    public String addWorkshop(WorkshopDTO workshopDTO) {
        Workshop workshop = workshopMapper.requestDtoToEntity(workshopDTO);
        if (!workshopRepo.existsById(workshop.getId())) {
            workshopRepo.save(workshop);
            return "saved " + workshop.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }
}
