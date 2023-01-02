package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.FactoryDTO;

import java.util.List;

public interface FactoryService {
    String addFactory(FactoryDTO factoryDTO);

    List<FactoryDTO> getAllfacts();
}
