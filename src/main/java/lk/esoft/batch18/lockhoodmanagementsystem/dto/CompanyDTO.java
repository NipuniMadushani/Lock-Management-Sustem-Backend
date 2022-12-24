package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDTO {
    private Long id;
    private String ownerName;
    private String regId;
    private String address;
    private int contactNumber;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
