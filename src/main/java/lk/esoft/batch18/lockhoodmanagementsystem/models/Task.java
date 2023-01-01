package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "task_description",length = 100)
    private String taskDescription;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @Column(name = "task_title",length = 100)
    private String taskTitle;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "supervision_id")
    private int supervisionId;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "report_id")
    private int reportId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToOne(mappedBy = "task")
    private KanBanCard kanBanCard;
}
