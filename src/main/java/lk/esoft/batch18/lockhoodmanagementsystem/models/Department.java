package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "manager_id")
    private int managerId;


    @OneToMany(mappedBy="department")
    private Set<User> users;



    @ManyToOne
    @JoinColumn(name="factory_id", nullable=false)
    private Factory factory;

    public Department(int id, String name, int managerId, Factory factory) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.factory = factory;
    }


}
