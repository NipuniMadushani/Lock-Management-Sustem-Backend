package lk.esoft.batch18.lockhoodmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCompanySaveDTO {

    private String ownerName;
    private String regId;
    private String address;
    private int contactNumber;
    private String createdBy;
    private String updatedBy;

}
