package hellojava.hellojavaspring.service;

import hellojava.hellojavaspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService= new MemberService();


    @Test
    void join() {
        //given : 무언가가 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when : 어떤행동을
        var saveid = memberService.join(member); //기존의 값이 있다면 , 오류가 날껍니다.
        //기존에 값이 있었는지 검사를 합니다, 만약에 있던값이 들어가게 되면 어쩌죠...?


        Member member1 = new Member();
        member1.setName("hello");

        Member finMember =memberService.findone(saveid).get();
        Assertions.assertThat(member.getName()).isEqualTo(finMember.getName());
        var saveid1 = memberService.join(member1); //기존의 값이 있다면 , 오류가 날껍니다.
        //then : 그리고나왓던 결과물

        int i=0;

    }

    @Test
    public void 중복_회원_예외_테스트()
    {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member1.setName("spring");

        memberService.join(member1);
        try
        {
           memberService.join(member2);
          fail();
        }
        catch(IllegalStateException e)
        {
            int i=0;
        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findone() {
    }
}