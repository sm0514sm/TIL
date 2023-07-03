package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import lombok.RequiredArgsConstructor;

import hello.hellospring.domain.Member;

@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {

  private final EntityManager em;

  @Override
  public Member save(Member member) {
    em.persist(member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(em.find(Member.class, id));
  }

  @Override
  public Optional<Member> findByName(String name) {
    List<Member> selectMFromMember = em.createQuery("select m from Member m where name = :name", Member.class)
      .setParameter("name", name)
      .getResultList();
    return selectMFromMember.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    return em.createQuery("select m from Member m", Member.class).getResultList();
  }
}
