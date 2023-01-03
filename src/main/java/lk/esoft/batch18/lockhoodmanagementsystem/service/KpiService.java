package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.KpiDTO;

import java.util.List;

public interface KpiService {
    String addKpi(KpiDTO kpiDTO);

    List<KpiDTO> getAllKpis();
}
