package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 에서 만든 unit-name
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member findMember = em.find(Member.class, 1L);
        findMember.setName("이상민BCCC");
//        em.persist(findMember);
        tx.commit();
        em.close();
        emf.close();
    }
}
