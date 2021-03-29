package hellojava.hellojavaspring.repository;

import hellojava.hellojavaspring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0l;

    @Override
    public Member Save(Member value) {
        value.setId(++sequence);
        store.put(value.getId(), value); //add 나 insert 가 아니라 put 입니다.
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

    //자바에서 실무할때는 list를 많이 씁니다
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public int Count() {
        return store.size();
    }

    public void clearStroe() {
        store.clear();
    }

}
