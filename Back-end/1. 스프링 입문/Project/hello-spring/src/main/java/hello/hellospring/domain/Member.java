package hello.hellospring.domain;

import javax.persistence.*;

// 객체와 DB를 JPA 를 통해 매핑
@Entity
public class Member {

//    @Id: key 값임을 나타냄
//    @GeneratedValue(strategy = GenerationType.IDENTITY): DB가 자동으로 생성해줌
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column: 클래스 field 명과 db field 명이 다른 경우
//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
