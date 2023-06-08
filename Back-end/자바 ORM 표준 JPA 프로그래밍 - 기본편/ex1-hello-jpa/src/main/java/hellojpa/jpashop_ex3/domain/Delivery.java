package hellojpa.jpashop_ex3.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

  @Id
  @GeneratedValue
  private Long id;

  private String city;

  private String street;

  private String zipcode;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;

  @OneToOne(mappedBy = "delivery")
  private Order order;
}
