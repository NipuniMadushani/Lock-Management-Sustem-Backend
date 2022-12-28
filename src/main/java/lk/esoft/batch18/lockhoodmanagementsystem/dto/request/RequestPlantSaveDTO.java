package lk.esoft.batch18.lockhoodmanagementsystem.dto.request;

import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPlantSaveDTO {

    private String plantLocation;
    private String plantName;
    private String plantRegId;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;


}
