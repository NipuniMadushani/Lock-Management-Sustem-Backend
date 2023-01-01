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

    @Column(name = "rd_department_id")
    private int rdDepartmentId;

    @Column(name = "rd_workshop_id")
    private int rdWorkshopId;

    @Column(name = "rd_supervisor_id")
    private int rdSupervisorId;

    @OneToMany(mappedBy="department")
    private Set<User> users;

    @OneToOne(mappedBy = "department")
    private Supervisor supervisor;



}
