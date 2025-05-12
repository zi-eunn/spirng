package hello.core.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    //저장소 만들기
    //실무에서는 동시성을 고려해야함 -> ConcurrentHashMap 사용
    public static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
    //뭐 안되면 Alt + enter

}
