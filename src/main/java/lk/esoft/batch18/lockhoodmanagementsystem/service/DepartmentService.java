package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    String addDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAlldeparts();
}
