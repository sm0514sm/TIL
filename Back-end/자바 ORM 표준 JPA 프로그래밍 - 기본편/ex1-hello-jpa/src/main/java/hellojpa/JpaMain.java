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
    try {
      // 영속 상태
      Member member = em.find(Member.class, 150L);
      member.setName("AAAAAAA");

      // 영속 상태 분리 (JPA에서 관리 안함)
      em.detach(member);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
  }
}
