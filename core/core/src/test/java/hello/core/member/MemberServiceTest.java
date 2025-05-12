package hello.core.member;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given - 이런게
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when - 주어졌을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then - 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
