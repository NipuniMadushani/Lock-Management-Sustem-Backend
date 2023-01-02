package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetTaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Company;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Task;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CompanyRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.DepartmentRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.DepartmentService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.DepartmentMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceIMPL implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public String addDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.requestDtoToEntity(departmentDTO);
        if (!departmentRepo.existsById(department.getId())) {
            departmentRepo.save(department);
            return "saved " + department.getId();
        }else {
            System.out.println("oo awa");
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<DepartmentDTO> getAlldeparts() {
        List<Department>departments = departmentRepo.findAll();
        if(departments!=null){
            List<DepartmentDTO> departs=modelMapper.
                    map(departments,new TypeToken<List<DepartmentDTO>>(){
                    }.getType());
            return departs;
        }else {
            throw new NotFoundException("No Data Found");
        }
    }
}
