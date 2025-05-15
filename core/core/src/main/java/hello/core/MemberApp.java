package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //테스트
    public static void main(String[] args) {
        //기능(Service)을 사용해야 함. 따라서 MemberServiceImpl 생성
        //MemberService memberService = new MemberServiceImpl();

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //스프링 생성하기 !! ApplicationContext가 @Bean을 다 관리해줌
        //AppConfig를 파라미터로 넣어주면
        //환경 설정 정볼르 가지고 @Bean을 컨테이너에 넣어서 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 이름 2. 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
