package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "com_owner_name",length = 100)
    private String ownerName;

    @Column(name = "reg_id",length = 100)
    private String regId;

    @Column(name = "address",length = 100)
    private String address;

    @Column(name = "contact_number",length = 100)
    private int contactNumber;

    @Column(name = "created_by",length = 100)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date",length = 100)
    private Date createdDate;

    @Column(name = "updated_by",length = 100)
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date",length = 100)
    private Date updatedDate;

    @OneToMany(mappedBy="company")
    private Set<User> users;

    @OneToMany(mappedBy="company")
    private Set<Customer> customers;

}
