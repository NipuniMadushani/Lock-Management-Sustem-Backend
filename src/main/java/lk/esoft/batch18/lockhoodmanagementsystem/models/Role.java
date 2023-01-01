package lk.esoft.batch18.lockhoodmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 50)
  private ERole name;

  public Role() {

  }

  public Role(Integer id, ERole name) {
    this.id = id;
    this.name = name;
  }

  public Role(ERole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }
}
