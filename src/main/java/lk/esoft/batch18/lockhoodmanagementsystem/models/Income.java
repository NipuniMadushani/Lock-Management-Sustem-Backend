package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "income")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description",length = 100)
    private String description;

    @Column(name = "amount",length = 100)
    private double amount;

    @OneToOne(mappedBy = "income")
    private Sale sale;
}
