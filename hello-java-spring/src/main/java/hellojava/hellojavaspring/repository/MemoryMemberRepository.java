package hellojava.hellojavaspring.repository;

import hellojava.hellojavaspring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store= new HashMap<>();
    private static long sequence=0l;

    @Override
    public Member Save(Member value) {
         value.setId(++sequence);
         store.put(value.getId(),value); //add 나 insert 가 아니라 put 입니다.
         return value;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional은 null인지 값을 검사해주는겁니다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
