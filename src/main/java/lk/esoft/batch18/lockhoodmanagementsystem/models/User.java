package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @Column(name = "f_name",length = 100)
  private String firstName;

  @Column(name = "address",length = 100)
  private String address;

  @Column(name = "e_com_email",length = 100)
  private String companyEmail;

  @Column(name = "contact_number",length = 100)
  private int contactNumber;

  @Column(name = "active_state",columnDefinition = "TINYINT default 1")
  private boolean activeState;

  @Column(name = "nic",length = 100)
  private String nic;

  @Column(name = "e_mname",length = 100)
  private String mName;

  @Column(name = "e_lname",length = 100)
  private String lastName;

  @Column(name = "image",length = 100)
  private String image;

  @Column(name = "created_by",length = 100)
  private String createdBy;

  @Column(name = "created_date",length = 100)
  private Date createdDate;

  @Column(name = "updated_by",length = 100)
  private String updatedBy;

  @Column(name = "updated_date",length = 100)
  private Date updatedDate;

  @ManyToOne
  @JoinColumn(name="company_id", nullable=false)
  private Company company;

  @ManyToOne
  @JoinColumn(name="plant", nullable=false)
  private Plant plant;


}
