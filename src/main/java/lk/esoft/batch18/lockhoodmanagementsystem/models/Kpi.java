package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "kpi")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Kpi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "target",length = 100)
    private String target;

    @Column(name = "achieved",length = 100)
    private String achieved;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="task_id", nullable=false)
    private Task task;
}
