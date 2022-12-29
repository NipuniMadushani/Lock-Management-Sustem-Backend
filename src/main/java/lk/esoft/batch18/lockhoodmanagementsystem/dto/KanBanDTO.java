package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Supervisor;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KanBanDTO {

    private int id;
    private boolean activeState;
    private int taskId;
    private int supervisorId;
}
