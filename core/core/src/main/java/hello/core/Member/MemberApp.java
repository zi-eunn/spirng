package hello.core.Member;

import hello.core.AppConfig;

public class MemberApp {
    //테스트
    public static void main(String[] args) {
        //기능(Service)을 사용해야 함. 따라서 MemberServiceImpl 생성
        //MemberService memberService = new MemberServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
