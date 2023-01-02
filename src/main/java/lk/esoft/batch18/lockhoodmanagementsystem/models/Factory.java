package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "factory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "type",length = 100)
    private String type;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Plant plant;

    @OneToMany(mappedBy="factory")
    private Set<Department> departments;

    @OneToMany(mappedBy="factory")
    private Set<Workshop> workshop;

    public Factory(int id, String name, String type, Plant plant) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.plant = plant;
    }
}
