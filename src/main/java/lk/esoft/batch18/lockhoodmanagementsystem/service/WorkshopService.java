package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;

import java.util.List;

public interface WorkshopService {
    String addWorkshop(WorkshopDTO workshopDTO);

    List<WorkshopDTO> getAllWorkshops();
}
