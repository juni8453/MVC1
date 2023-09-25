package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    List<Member> members = memberRepository.findAll();

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    PrintWriter w = response.getWriter();
    for (Member member : members) {
      w.write("    <tr>");
      w.write("        <td>" + member.getId() + "</td>");
      w.write("        <td>" + member.getUsername() + "</td>");
      w.write("        <td>" + member.getAge() + "</td>");
      w.write("    </tr>");
    }
    w.write("    </tbody>");
    w.write("</table>");
    w.write("</body>");
    w.write("</html>");
  }
}
