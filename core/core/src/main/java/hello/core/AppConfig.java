package hello.core;

import hello.core.Member.MemberRepository;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//    public OrderService orderService() {
//        return new OrderServiceImpl(
//                new MemoryMemberRepository(),
//                new FixDiscountPolicy()
//        );
//    }

    //리팩토링 ctrl + alt + M
    //리팩토링 장점 1 : 어떤걸 사용할 지 역할이 한 눈에 보임
    //리팩토링 장점 2 : DB가 변경될 때 이 코드만 바꾸면 됨
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //new memberRepository() 중복을 막기 위해 리팩토링
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public RateDiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
