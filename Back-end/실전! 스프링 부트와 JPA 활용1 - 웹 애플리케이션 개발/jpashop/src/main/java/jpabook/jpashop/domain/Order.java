package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") // foreign key 지정
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    // Date 와 달리 LocalDateTime 사용하면 DB와 알아서 매핑
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL 이면 0, 1, 2 .. 순으로 들어가는데 중간에 값이 추가되면 장애발생
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]
}
