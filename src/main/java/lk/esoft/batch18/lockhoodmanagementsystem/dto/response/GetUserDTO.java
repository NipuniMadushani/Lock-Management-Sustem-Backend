package lk.esoft.batch18.lockhoodmanagementsystem.dto.response;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.CompanyDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.PlantDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUserDTO {
    private Long id;
    private String username;
    private String email;
    private Set<Role> roles;
    private String password;
    private String firstName;
    private String address;
    private String companyEmail;
    private int contactNumber;
    private boolean activeState;
    private String nic;
    private String mName;
    private String lastName;
    private String image;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private CompanyDTO companyId;
    private PlantDTO plantId;
}
