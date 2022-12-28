package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetCompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated.PaginatedGetPlantDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestCompanySaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.request.RequestPlantSaveDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.service.CompanyService;
import lk.esoft.batch18.lockhoodmanagementsystem.service.PlantService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api/v1/plant")
@CrossOrigin
public class PlantController {
    @Autowired
    private PlantService plantService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> savePlant(@RequestBody RequestPlantSaveDTO requestPlantSaveDTO) {
        String message = plantService.addPlant(requestPlantSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-plant"}
    )
    public ResponseEntity<StandardResponse> getAllPlant() {
        int page = 0;
        int size = 1000;
        PaginatedGetPlantDTO paginatedGetPlantDTO = plantService.getAllPlants(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedGetPlantDTO),
                HttpStatus.OK
        );
    }

}
