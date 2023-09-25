package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Member member = new Member("memberA", 20);

    // when
    Member saveMember = memberRepository.save(member);

    // then
    Member findMember = memberRepository.findById(saveMember.getId());
    assertThat(findMember).isEqualTo(saveMember);
  }

  @Test
  void findAll() {
    // given
    Member memberA = new Member("memberA", 10);
    Member memberB = new Member("memberB", 20);

    // when
    Member saveMemberA = memberRepository.save(memberA);
    Member saveMemberB = memberRepository.save(memberB);

    // then
    Member findMemberA = memberRepository.findById(saveMemberA.getId());
    Member findMemberB = memberRepository.findById(saveMemberB.getId());
    assertThat(findMemberA).isEqualTo(saveMemberA);
    assertThat(findMemberB).isEqualTo(saveMemberB);
  }

}