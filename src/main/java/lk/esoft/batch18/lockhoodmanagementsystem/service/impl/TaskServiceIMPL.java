package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.TaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetTaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Plant;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Task;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CompanyRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.TaskRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.UserRepository;
import lk.esoft.batch18.lockhoodmanagementsystem.service.TaskService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.TaskMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addTask(TaskDTO taskDTO) {
        Task task = taskMapper.dtoToEntity(taskDTO);
        if (!taskRepo.existsById(task.getId())) {
            task.setUser(userRepository.getById(taskDTO.getUserId()));
            taskRepo.save(task);
            return "saved " + task.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<GetTaskDTO> getAllTasks() {
        List<Task>task = taskRepo.findAll();
        if(task!=null){
            List<GetTaskDTO> tasks=modelMapper.
                    map(task,new TypeToken<List<GetTaskDTO>>(){
                    }.getType());
            return tasks;
        }else {
            throw new NotFoundException("No Data Found");
        }
    }
}
