package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // 기본값은 클래스명
@Getter
@Setter
public class Album extends Item {
    private String artist;
    private String ect;
}
