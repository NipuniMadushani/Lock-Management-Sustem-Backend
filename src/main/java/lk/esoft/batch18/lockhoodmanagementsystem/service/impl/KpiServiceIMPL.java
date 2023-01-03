package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.KpiDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Factory;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Kpi;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Workshop;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.KpiRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.PlantRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.UserRepository;
import lk.esoft.batch18.lockhoodmanagementsystem.service.KpiService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.KpiMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.PlantMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class KpiServiceIMPL implements KpiService {
    @Autowired
    private KpiRepo kpiRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private KpiMapper kpiMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addKpi(KpiDTO kpiDTO) {
        Kpi kpi = kpiMapper.requestDtoToEntity(kpiDTO);
        kpi.setUser(userRepository.getById(kpiDTO.getUserId()));

        if (!kpiRepo.existsById(kpi.getId())) {
            kpiRepo.save(kpi);
            return "saved " + kpi.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<KpiDTO> getAllKpis() {
        List<Kpi> kpis = kpiRepo.findAll();
        if (kpis != null) {
            List<KpiDTO> kpi = modelMapper.
                    map(kpis, new TypeToken<List<KpiDTO>>() {
                    }.getType());
            return kpi;
        } else {
            throw new NotFoundException("No Data Found");
        }
    }
}
