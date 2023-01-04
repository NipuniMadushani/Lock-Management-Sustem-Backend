package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "brand",length = 100)
    private String brand;

    @Column(name = "manufactured_cost",length = 100)
    private double manufacturedCost;

    @Column(name = "selling_price",length = 100)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "manufactured_date",length = 100)
    private Date manufacturedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expired_date",length = 100)
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name="workshop_id", nullable=false)
    private Workshop workshop;

    @ManyToOne
    @JoinColumn(name="sale_id", nullable=false)
    private Sale sale;
}
