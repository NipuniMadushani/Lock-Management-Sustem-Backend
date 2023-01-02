package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Factory;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.FactoryRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.FactoryService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.FactoryMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class FactoryServiceIMPL implements FactoryService {
    @Autowired
    private FactoryRepo factoryRepo;

    @Autowired
    private FactoryMapper factoryMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addFactory(FactoryDTO factoryDTO) {
        Factory factory = factoryMapper.requestDtoToEntity(factoryDTO);
        if (!factoryRepo.existsById(factory.getId())) {
            factoryRepo.save(factory);
            return "saved " + factory.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<FactoryDTO> getAllfacts() {
        List<Factory> factories = factoryRepo.findAll();
        if(factories!=null){
            List<FactoryDTO> facto=modelMapper.
                    map(factories,new TypeToken<List<FactoryDTO>>(){
                    }.getType());
            return facto;
        }else {
            throw new NotFoundException("No Data Found");
        }
    }
}
