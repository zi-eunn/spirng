package hello.core.Member;

//사용자가 사용 가능한 기능 구현
public class MemberServiceImpl implements MemberService {

    //가입을 하고 회원을 찾으려면 Repository 필요
    //NullPointInception 발생 -> 구현 객체를 선택해야함.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
