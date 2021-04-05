package hellojava.hellojavaspring;


import hellojava.hellojavaspring.repository.JdbcMemberRepository;
import hellojava.hellojavaspring.repository.MemberRepository;
import hellojava.hellojavaspring.repository.MemoryMemberRepository;
import hellojava.hellojavaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Autowired
    DataSource dataSource;

    public SpringConfig(DataSource dataSource)
    {
        this.dataSource=dataSource;
    }


    @Bean //스프링 빈에 등록하라는 의미
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
    // return new MemoryMemberRepository();
     return new JdbcMemberRepository(dataSource);
    }


}
