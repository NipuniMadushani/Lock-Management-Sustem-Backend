package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.SupervisorDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Supervisor;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.DepartmentRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.SupervisorRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.SupervisorService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.DepartmentMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.SupervisorMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class SupervisorServiceIMPL implements SupervisorService {
    @Autowired
    private SupervisorRepo supervisorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SupervisorMapper supervisorMapper;
    @Override
    public String addSupervisor(SupervisorDTO supervisorDTO) {
        Supervisor supervisor = supervisorMapper.requestDtoToEntity(supervisorDTO);
        if (!supervisorRepo.existsById(supervisor.getId())) {

            supervisorRepo.save(supervisor);
            return "saved " + supervisor.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<SupervisorDTO> getAllSuper() {
        List<Supervisor>supervisors = supervisorRepo.findAll();
        if(supervisors!=null){
            List<SupervisorDTO> departs=modelMapper.
                    map(supervisors,new TypeToken<List<SupervisorDTO>>(){
                    }.getType());
            return departs;
        }else {
            throw new NotFoundException("No Data Found");
        }
    }
}
