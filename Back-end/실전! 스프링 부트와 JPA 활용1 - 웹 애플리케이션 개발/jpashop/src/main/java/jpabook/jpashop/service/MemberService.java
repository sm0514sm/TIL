package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // @Component 있어서 ComponentScan에 사용됨
@Transactional(readOnly = true)     // JPA의 모든 처리는 트랜잭션 안에서 일어나야함 (public method에 적용됨)
                                    // (javax, spring의 @Transcational이 있는데 spring쓰자)
                                    // readOnly 설정하면 조회때 성능 증가
@RequiredArgsConstructor // final 인 필드만 constructor 생성해줌
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional(readOnly = false) // readOnly 설정하면 write 불가해짐
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
