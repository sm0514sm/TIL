package hellojpa.jpashop_ex3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.jpashop_ex3.domain.Order;
import hellojpa.jpashop_ex3.domain.OrderItem;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 에서 만든 unit-name
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    try {
      Order order = new Order();
      order.addOrderItem(new OrderItem());
      em.persist(order);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
