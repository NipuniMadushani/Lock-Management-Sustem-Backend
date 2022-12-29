package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {
    private int id;
    private String taskDescription;
    private boolean activeState;
    private String taskTitle;
    private Date startTime;
    private Date endTime;
    private Date startDate;
    private Date dueDate;
    private int supervisionId;
    private int departmentId;
    private int reportId;
    private int userId;
}


