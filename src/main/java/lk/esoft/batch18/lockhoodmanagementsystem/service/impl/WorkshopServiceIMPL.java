package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Workshop;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.WorkshopRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.WorkshopService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.WorkshopMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class WorkshopServiceIMPL implements WorkshopService {
    @Autowired
    private WorkshopRepo workshopRepo;

    @Autowired
    private WorkshopMapper workshopMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addWorkshop(WorkshopDTO workshopDTO) {
        Workshop workshop = workshopMapper.requestDtoToEntity(workshopDTO);
        if (!workshopRepo.existsById(workshop.getId())) {
            workshopRepo.save(workshop);
            return "saved " + workshop.getId();
        } else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<WorkshopDTO> getAllWorkshops() {
        List<Workshop> workshops = workshopRepo.findAll();
        if (workshops != null) {
            List<WorkshopDTO> work = modelMapper.
                    map(workshops, new TypeToken<List<WorkshopDTO>>() {
                    }.getType());
            return work;
        } else {
            throw new NotFoundException("No Data Found");
        }
    }
}

