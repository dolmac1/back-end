package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        Member member = new Member(1L,"dolmac",Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        Assertions.assertThat(member).isEqualTo(findMember);
        System.out.println(member.getName());
    }
}
