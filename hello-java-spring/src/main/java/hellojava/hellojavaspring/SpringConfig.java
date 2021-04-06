package hellojava.hellojavaspring;


import hellojava.hellojavaspring.repository.MemberRepository;
import hellojava.hellojavaspring.repository.MemoryMemberRepository;
import hellojava.hellojavaspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean //스프링 빈에 등록하라는 의미
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
     return new MemoryMemberRepository();
    }


}
