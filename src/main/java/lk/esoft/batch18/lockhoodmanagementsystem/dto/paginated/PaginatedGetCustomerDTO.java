package lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.CompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedGetCustomerDTO {
    private List<CustomerDTO> list;
    private long dataCount;
}
