package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.KanBanDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.DepartmentService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.KanBanService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kanban")
@CrossOrigin
public class KanBanController {

    @Autowired
    private KanBanService kanBanService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveKanBan(@RequestBody KanBanDTO kanBanDTO) {
        String message = kanBanService.addKanBan(kanBanDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }
}
