package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.TaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCustomerSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetTaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CustomerService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.TaskService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveTask(@RequestBody TaskDTO taskDTO) {
        String message = taskService.addTask(taskDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-tasks")
    public ResponseEntity<StandardResponse> getAlltasks(){
        List<GetTaskDTO> allTasks = taskService.getAllTasks();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allTasks),
                HttpStatus.OK
        );

    }
}