package hellojava.hellojavaspring.service;

import hellojava.hellojavaspring.domain.Member;
import hellojava.hellojavaspring.repository.MemberRepository;
import hellojava.hellojavaspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //여기에 들어갈기능 , 회원가입
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
//        //같은 이름이 있는 중복 회원은 안됩니다.
//        Optional<Member> result= memberRepository.findByName(member.getName());
//
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 있는 회원입니다");
//
//        });

        //같은 이름이 있는 중복 회원은 안됩니다.
        vaildateDuplicateMember(member);
        memberRepository.Save(member);
        return member.getId();
    }

    //중복회원 검증 함수
    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 있는 회원입니다");
        });
    }


    /*전체의 회원 조회.*/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findone(Long Memberid)
    {
        return memberRepository.findById(Memberid);
    }

}
