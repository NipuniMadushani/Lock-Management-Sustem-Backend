package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "address",length = 100)
    private String address;

    @Column(name = "email",length = 100)
    private String email;

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

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

}
