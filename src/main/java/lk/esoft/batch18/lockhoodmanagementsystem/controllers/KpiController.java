package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.DepartmentDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.KpiDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.WorkshopDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.DepartmentService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.KpiService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kpi")
@CrossOrigin
public class KpiController {
    @Autowired
    private KpiService kpiService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveKpi(@RequestBody KpiDTO kpiDTO) {
        String message = kpiService.addKpi(kpiDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-kpi")
    public ResponseEntity<StandardResponse> getAllKpi(){
        List<KpiDTO> allKpi = kpiService.getAllKpis();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allKpi),
                HttpStatus.OK
        );

    }
}
