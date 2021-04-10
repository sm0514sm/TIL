package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // 스프링 컨테이너에게 Service, Repository 내놔!
    // 테스트는 가장 마지막에 하는 것이므로 Constructor 없이 Autowired 로 바로 DI 해도됨
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
//    @Commit // 진짜 추가됨
    void 회원가입() {
//        assertThat(memberRepository).isEqualTo(memberService.memberRepository);
//        given: 주어진 상황에서 (데이터)
        Member member = new Member();
        member.setName("spring");

//        when: 무엇을 실행할 때 (무엇을 테스트?)
        Long saveId = memberService.join(member);

//        then: 이렇게 되도록 (검증)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
//        given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

//        when
        memberService.join(member1);

//        then
//         실행될 때 이 예외가 터져야 정상이다!
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}