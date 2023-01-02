package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.FactoryService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.WorkshopService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workshop")
@CrossOrigin
public class WorkshopController {
    @Autowired
    private WorkshopService workshopService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveWorkshop(@RequestBody WorkshopDTO workshopDTO) {
        String message = workshopService.addWorkshop(workshopDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }
}
