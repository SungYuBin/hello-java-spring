package hellojava.hellojavaspring.repository;


import hellojava.hellojavaspring.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    //생성자
    public JdbcMemberRepository(DataSource dataSource)
    {
        this.dataSource=dataSource;
        dataSource.getConnection()
    }

    @Override
    public Member Save(Member value) {
        String sql = "insert into member(name) values(?)";
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public int Count() {
        return 0;
    }
}
