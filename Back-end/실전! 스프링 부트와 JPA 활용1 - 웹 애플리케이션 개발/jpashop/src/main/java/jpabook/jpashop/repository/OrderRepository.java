package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        // 방법 1: orderSearch의 필드들이 null이 아니라면 이렇게 하면 됨. (대신 null일 경우 동적으로 불가!)
        List<Order> resultList1 = solution1(orderSearch);

        // 방법 2: JPA 문자로 해결하는 무식한 방법 !사용하지마! 굉장히 비효율적
        List<Order> resultList2 = solution2(orderSearch);

        // 방법 3: JPA Criteria 표준. 이런게 있다~
        List<Order> resultList3 = solution3(orderSearch);

        // 방법 4: QueryDsl
        // 나중에

        return resultList3;
    }

    private List<Order> solution1(OrderSearch orderSearch) {
        return em.createQuery("select o from Order o join o.member m" +
                        " where o.status = :status" +
                        " and m.name like :name", Order.class)
                .setParameter("status", orderSearch.getOrderStatus())
                .setParameter("name", orderSearch.getMemberName())
                .setMaxResults(1000) // 최대 1000건
                .getResultList();
    }

    private List<Order> solution2(OrderSearch orderSearch) {
        String jpql = "select o from Order o join o.member m";
        boolean isFirst = true;
        if (orderSearch.getOrderStatus() != null) {
            if (isFirst) {
                jpql += " where";
                isFirst = false;
            } else {
                jpql += " and";
            }
            jpql += " o.status = :status";
        }
        // getMemberName()도 마찬가지로 위 작업
        TypedQuery<Order> query = em.createQuery(jpql, Order.class).setMaxResults(1000);
        if (orderSearch.getOrderStatus() != null){
            query = query.setParameter("status", orderSearch.getOrderStatus());
        }
        return query.getResultList();
    }


    /**
     * JPA Criteria 표준<br>
     * 권장하는 방법은 아님. 간략히 설명만. 이런게 있다~<br>
     * 유지 보수 매우 힘듬
     */
    public List<Order> solution3(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);
        Join<Object, Object> m = o.join("member", JoinType.INNER);
        List<Predicate> criteria = new ArrayList<>();

        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }
        // 회원 이름 검색
        if (orderSearch.getMemberName() != null) {
            Predicate status = cb.like(m.<String>get("name"), "%" + orderSearch.getMemberName() + "%");
            criteria.add(status);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }
}
