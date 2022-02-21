package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // 한 테이블 에서 type 으로 구분하려고 싱글 테이블
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item{

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
