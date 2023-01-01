package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.SupervisorDTO;

import java.util.List;

public interface SupervisorService {
    String addSupervisor(SupervisorDTO supervisorDTO);

    List<SupervisorDTO> getAllSuper();
}
