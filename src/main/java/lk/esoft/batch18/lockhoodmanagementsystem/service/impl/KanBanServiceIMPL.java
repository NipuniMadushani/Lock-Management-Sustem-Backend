package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.KanBanDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.KanBanCard;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.DepartmentRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.KanBanRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.SupervisorRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.TaskRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.KanBanService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.DepartmentMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.KanBanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;

@Service
public class KanBanServiceIMPL implements KanBanService {

    @Autowired
    private KanBanRepo kanBanRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private KanBanMapper kanBanMapper;

    @Autowired
    private SupervisorRepo supervisorRepo;

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public String addKanBan(KanBanDTO kanBanDTO) {
        KanBanCard kanBanCard = kanBanMapper.requestDtoToEntity(kanBanDTO);
        if (!kanBanRepo.existsById(kanBanCard.getId())) {
            kanBanCard.setSupervisor(supervisorRepo.getById(kanBanDTO.getSupervisorId()));
            kanBanCard.setTask(taskRepo.getById(kanBanDTO.getTaskId()));

            kanBanRepo.save(kanBanCard);
            return "saved " + kanBanCard.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }
}
