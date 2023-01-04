package lk.esoft.batch18.lockhoodmanagementsystem.dto;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Customer;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Income;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
    private int id;
    private Date saleDate;
    private double quantity;
    private double totalAmount;
    private CustomerDTO customer;
    private IncomeDTO income;

}
