package lk.esoft.batch18.lockhoodmanagementsystem.payload.request;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<Role> roles;

  @NotBlank
  @Size(min = 6, max = 40)

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
  private int companyId;
  private int plantId;
  private int departmentId;

}
