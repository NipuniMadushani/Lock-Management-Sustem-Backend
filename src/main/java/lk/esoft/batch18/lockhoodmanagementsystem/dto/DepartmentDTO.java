package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int managerId;
//    private int rdDepartmentId;
//    private int rdWorkshopId;
//    private int rdSupervisorId;
    private FactoryDTO factory;
}
