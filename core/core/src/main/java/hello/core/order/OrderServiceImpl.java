package hello.core.order;

import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//롬복으로 생성자 만들어짐 -> ctrl + f12로 생성자 확인가능
public class OrderServiceImpl implements OrderService{

    //memberRepository에서 회원 찾아야 함
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인된 가격 계산 해야하니까 -> 고정 할인 정책
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //AppConfig 후에 아래처럼 사용
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    } //lombok을 사용하면 생성자 생략가능!
    //final이 붙은 애들로 생성자를 자동으로 만들어줌

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //멤버 찾고
        Member member = memberRepository.findById(memberId);
        //할인은 discountPolicy니가 던져줘라 난 모르겠다. -> 단일 체계 원칙 잘 설계됨
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
