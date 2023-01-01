package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.SupervisorDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.DepartmentService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.SupervisorService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supervisor")
@CrossOrigin
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveSupervisor(@RequestBody SupervisorDTO supervisorDTO) {
        String message = supervisorService.addSupervisor(supervisorDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-supervisor")
    public ResponseEntity<StandardResponse> getAllSupervisor(){
        List<SupervisorDTO> allDeparts = supervisorService.getAllSuper();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allDeparts),
                HttpStatus.OK
        );

    }

}
