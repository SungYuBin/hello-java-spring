package hellojava.hellojavaspring.repository;

import hellojava.hellojavaspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//spring의 경우 테스트를 진행할때 계속 웹사이트를 틀어놓고 테스트하는데 번거로움이 있기때문에 이런식으로 테스트 케이스를 작성해서 값이 들어가는지를 확인 할 수 있음,
// 테스트를 진행 하기 위한 공간
public class MemoryMemeberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
//given
        Member member = new Member();
        member.setName("spring");
//when
        repository.save(member);
//then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }
    @Test
    public void findByName() {
//given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
//when
        Member result = repository.findByName("spring1").get();
//then
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
//given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
//when
        List<Member> result = repository.findAll();
//then
        assertThat(result.size()).isEqualTo(2);
    }
}
