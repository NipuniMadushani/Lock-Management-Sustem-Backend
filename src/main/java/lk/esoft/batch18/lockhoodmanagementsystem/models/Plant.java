package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "plant")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plant_location",length = 100)
    private String plantLocation;

    @Column(name = "plant_name",length = 100)
    private String plantName;

    @Column(name = "plant_reg_id",length = 100)
    private String plantRegId;

    @OneToMany(mappedBy="plant")
    private Set<User> users;

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
}
