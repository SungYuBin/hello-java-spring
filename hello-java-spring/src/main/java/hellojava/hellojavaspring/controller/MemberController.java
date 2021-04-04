package hellojava.hellojavaspring.controller;

import hellojava.hellojavaspring.domain.Member;
import hellojava.hellojavaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    //의존관계의 주입
    //각각의 선을 주입합니다
    @Autowired //Controller 와 service 를 연결합니다.// 생성자를 활용할떄 이런식으로 진행하는게 맞는듯 합니다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
