package hello.core.member;

import hello.core.AppConfig;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    //각 테스트 실행전에 무조건 실행되는 것
    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    public
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
