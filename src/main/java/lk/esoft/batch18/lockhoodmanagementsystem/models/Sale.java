package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sale")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_date",length = 100)
    private Date saleDate;

    @Column(name = "quantity",length = 100)
    private double quantity;

    @Column(name = "total_amount",length = 100)
    private double totalAmount;

    @OneToMany(mappedBy="sale")
    private Set<Product> product;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_id", referencedColumnName = "id")
    private Income income;
}
