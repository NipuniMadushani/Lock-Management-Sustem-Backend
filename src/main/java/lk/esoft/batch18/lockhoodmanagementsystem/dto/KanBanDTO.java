package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KanBanDTO {

    private int id;
    private boolean activeState;
    private int taskId;
    private int userId;
}
