package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.TaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetTaskDTO;

import java.util.List;

public interface TaskService {
    String addTask(TaskDTO taskDTO);

    List<GetTaskDTO> getAllTasks();
}
