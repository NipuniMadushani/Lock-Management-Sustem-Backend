package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private int contactNumber;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private long companyId;
}
