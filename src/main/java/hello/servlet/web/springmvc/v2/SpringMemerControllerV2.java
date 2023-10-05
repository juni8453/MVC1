package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemerControllerV2 {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @RequestMapping("/new-form")
  public ModelAndView newForm() {
    return new ModelAndView("new-form");
  }

  @RequestMapping("/members/save")
  public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

    ModelAndView modelAndView = new ModelAndView("save");
    modelAndView.addObject("member", member);

    return modelAndView;
  }

  @RequestMapping("/members")
  public ModelAndView members() {
    List<Member> members = memberRepository.findAll();

    ModelAndView modelAndView = new ModelAndView("members");
    modelAndView.addObject(members);

    return modelAndView;
  }

}
