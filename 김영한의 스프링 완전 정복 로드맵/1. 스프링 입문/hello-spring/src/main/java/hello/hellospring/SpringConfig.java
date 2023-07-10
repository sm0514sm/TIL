package hello.hellospring;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

  private final EntityManager entityManager;
  private final MemberRepository memberRepository;

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

  // @Bean
  // public MemberRepository memberRepository() {
  // return new MemoryMemberRepository();
  // return new JdbcMemberRepository(dataSource);
  // return new JdbcTemplateMemberRepository(dataSource);
  // return new JpaMemberRepository(entityManager);
  // }
}
