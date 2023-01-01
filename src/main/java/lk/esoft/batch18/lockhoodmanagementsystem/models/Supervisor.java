package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "supervisor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "nic",length = 100)
    private String nic;

    @Column(name = "address",length = 100)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToOne(mappedBy = "supervisor")
    private KanBanCard kanBanCard;


}
