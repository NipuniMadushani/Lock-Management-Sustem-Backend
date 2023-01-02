package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "workshops")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "address",length = 100)
    private String address;

    @Column(name = "email",length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name="factory_id", nullable=false)
    private Factory factory;

}
