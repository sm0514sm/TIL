package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // 한 테이블 에서 type 으로 구분하려고 싱글 테이블
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //== 비즈니스 로직 ==//
    // itemService 같은 거에서 getStockQuantity 그러는게 아니라 entity에 로직을 추가해 응집력 상승
    /**
     * 재고 stock 증가
    */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * 재고 stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity -quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
