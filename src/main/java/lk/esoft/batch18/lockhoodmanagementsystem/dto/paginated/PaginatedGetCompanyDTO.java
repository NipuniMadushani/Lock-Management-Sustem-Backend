package lk.esoft.batch18.lockhoodmanagementsystem.dto.paginated;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedGetCompanyDTO {
    private List<CompanyDTO> list;
    private long dataCount;
}
