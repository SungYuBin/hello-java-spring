package hellojava.hellojavaspring.repository;

import hellojava.hellojavaspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member Save(Member value);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

    int Count();
}
