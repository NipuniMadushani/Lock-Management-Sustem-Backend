package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Task;
import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KpiDTO {
    private int id;
    private String name;
    private String target;
    private String achieved;
    private int userId;
    private TaskDTO task;
}
