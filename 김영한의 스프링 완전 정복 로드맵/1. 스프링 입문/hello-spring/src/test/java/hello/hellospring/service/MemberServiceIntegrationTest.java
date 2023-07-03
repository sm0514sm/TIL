package hello.hellospring.service;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;

@SpringBootTest
@Transactional
@DisplayName("MemberService 스프링 통합 테스트")
class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;

  @Autowired
  MemberRepository memberRepository;

  @Test
  @DisplayName("회원가입")
  void join() {
    // given
    Member member = new Member();
    member.setName("hello");

    // when
    Long saveId = memberService.join(member);

    // then
    Optional<Member> findMember = memberService.findOne(saveId);
    assertThat(member.getName()).isEqualTo(findMember.map(Member::getName).orElse(null));
  }

  @Test
  @DisplayName("중복 회원 예외")
  public void duplicateMember() {
    // given
    Member member1 = new Member();
    member1.setName("hello");
    Member member2 = new Member();
    member2.setName("hello");

    // when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
  }
}