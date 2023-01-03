package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.KanBanDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.KanBanCard;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.*;
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
    private UserRepository userRepository;

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public String addKanBan(KanBanDTO kanBanDTO) {
        KanBanCard kanBanCard = kanBanMapper.requestDtoToEntity(kanBanDTO);
        if (!kanBanRepo.existsById(kanBanCard.getId())) {
            kanBanCard.setUser(userRepository.getById(kanBanDTO.getUserId()));
            kanBanCard.setTask(taskRepo.getById(kanBanDTO.getTaskId()));

            kanBanRepo.save(kanBanCard);
            return "saved " + kanBanCard.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }
}
