package hello.core.Member;

//사용자가 사용 가능한 기능 구현
public class MemberServiceImpl implements MemberService {

    //가입을 하고 회원을 찾으려면 Repository 필요
    //NullPointInception 발생 -> 구현 객체를 선택해야함.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    //AppConfig를 만들고 난 후엔 아래처럼 사용, 생성자 추가
    private final MemberRepository memberRepository;

    //memberrespository에 뭐가 들어갈 지 생성자를 통해서 선택을 함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
