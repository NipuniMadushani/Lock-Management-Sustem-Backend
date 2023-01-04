package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Sale;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Workshop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int id;
    private String name;
    private String brand;
    private double manufacturedCost;
    private double sellingPrice;
    private boolean activeState;
    private Date manufacturedDate;
    private Date expireDate;
    private WorkshopDTO workshop;
    private SaleDTO sale;
}
