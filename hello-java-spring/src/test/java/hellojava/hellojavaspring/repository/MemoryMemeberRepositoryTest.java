package hellojava.hellojavaspring.repository;

import hellojava.hellojavaspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//spring의 경우 테스트를 진행할때 계속 웹사이트를 틀어놓고 테스트하는데 번거로움이 있기때문에 이런식으로 테스트 케이스를 작성해서 값이 들어가는지를 확인 할 수 있음,
// 테스트를 진행 하기 위한 공간
public class MemoryMemeberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트 케이스가 한번씩 돌때마다 자동 실행되는 함수입니다.
    @AfterEach
    public void afterEach()
    {
        repository.clearStroe();
    }

    @Test
    public void save()
    {
        Member member= new Member();
        member.setName("왜이러시나요");

        repository.Save(member);

        //Member result= repository.findById(member.getId()).get();
        //Assertions.assertEquals(member,result);
        //System.out.println("와이라노");

    }

    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("이건 1번입니다");

        Member member2= new Member();
        member2.setName("이건 2번입니다");

        repository.Save(member1);
        repository.Save(member2);

        var test = repository.findById(member1.getId()).get(); //여기서 get()을 안하면 알맞는 값이 안됩니다 우와;;;
        int count= repository.Count(); //갯수는 2개로 나옵니다 함수별로 따로따로 움직이는듯합니다.

                    //기준값       //비교값               //기준값과 비교값이 같아야 합니다.
        assertThat(test).isEqualTo(member1); //결과값이 맞지 않는다면, 프로그램자체가 실행되지않습니다 //우와 알맞는 값을 입력하면 잘 실행됩니다

        //main 을 따로 안만들고 따로따로 진행 해서 테스트 할 수 있습니다.
        //다수의 main
        int s=0;

    }

}
