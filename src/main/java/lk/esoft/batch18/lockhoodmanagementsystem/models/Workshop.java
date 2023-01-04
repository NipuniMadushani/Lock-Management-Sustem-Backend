package lk.esoft.batch18.lockhoodmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy="workshop")
    private Set<Product> product;

    public Workshop(int id, String name, String address, String email, Factory factory) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.factory = factory;
    }
}
