package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.IncomeDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.ProductDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Income;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Product;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.IncomeRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.ProductRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.service.IncomeService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.IncomeMapper;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.ProductMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class IncomeServiceIMPL implements IncomeService {
    @Autowired
    private IncomeRepo incomeRepo;

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String addIncome(IncomeDTO incomeDTO) {
        Income income = incomeMapper.requestDtoToEntity(incomeDTO);
        if (!incomeRepo.existsById(income.getId())) {
            incomeRepo.save(income);
            return "saved " + income.getId();
        }else {
            throw new KeyAlreadyExistsException("Already Exists");
        }
    }

    @Override
    public List<IncomeDTO> getAllIncome() {
        List<Income> incomes = incomeRepo.findAll();
        if (incomes != null) {
            List<IncomeDTO> income = modelMapper.
                    map(incomes, new TypeToken<List<IncomeDTO>>() {
                    }.getType());
            return income;
        } else {
            throw new NotFoundException("No Data Found");
        }
    }
}
