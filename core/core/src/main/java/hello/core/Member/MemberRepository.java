package hello.core.Member;

//회원 저장소
public interface MemberRepository {

    void save(Member member); //회원 저장
    Member findById(Long memberId); //회원 아이디로 멤버 찾기
}
