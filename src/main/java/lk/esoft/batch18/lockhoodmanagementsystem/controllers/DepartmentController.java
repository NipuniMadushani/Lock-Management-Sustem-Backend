package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.TaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetTaskDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.DepartmentService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.TaskService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        String message = departmentService.addDepartment(departmentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-departments")
    public ResponseEntity<StandardResponse> getAllDepartments(){
        List<DepartmentDTO> allDeparts = departmentService.getAlldeparts();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allDeparts),
                HttpStatus.OK
        );

    }

}
