package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 기본값은 클래스명
@Getter
@Setter
public class Book extends Item {
    private String author;
    private String isbn;
}
