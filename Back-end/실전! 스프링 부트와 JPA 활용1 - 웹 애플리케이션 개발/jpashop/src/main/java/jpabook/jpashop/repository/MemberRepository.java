package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // @Component 있어서 ComponentScan에 사용됨
@RequiredArgsConstructor
public class MemberRepository {

    // @PersistenceContext // EntityManager를 만들어서 주입해줌
    // 원래는 PersistenceContext 써야하지만 Spring boot 에서 Autowire 지원해줘서 이거 써도됨
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        // sql과 거의 비슷하지만, JPQL에서는 객체를 대상으로 쿼리
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
