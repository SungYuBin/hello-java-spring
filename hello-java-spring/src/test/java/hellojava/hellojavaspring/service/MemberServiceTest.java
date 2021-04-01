package hellojava.hellojavaspring.service;

import hellojava.hellojavaspring.domain.Member;
import hellojava.hellojavaspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService; //맴버 서비스
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforEach(){
        memoryMemberRepository= new MemoryMemberRepository();
        memberService= new MemberService(memoryMemberRepository);

    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStroe();
    }


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
        assertThat(member.getName()).isEqualTo(finMember.getName());
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
       // IllegalStateException e =assertThrows(IllegalStateException.class, ()-> memberService.join(member2)); //예외 발생 시킴
//        assertThat(e.getMessage()).isEqualTo("이미 있는 회원입니다"); //입력된 두개의 파라미터 비교값이

//        try
//        {
//           memberService.join(member2);
//          fail();
//        }
//        catch(IllegalStateException e)
//        {
//            int i=0;
//        }
        int i=0;
    }

    @Test
    void findMembers() {
    }

    @Test
    void findone() {
    }
}