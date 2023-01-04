package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.IncomeDTO;

import java.util.List;

public interface IncomeService {
    String addIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncome();
}
