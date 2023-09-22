package hello.servlet.basic.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  1. Request 요청 GET Query Parameter 사용
  2. username, age 데이터 전송
*/
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    System.out.println("[전체 파라미터 조회] START");
    request.getParameterNames().asIterator()
        .forEachRemaining(parameterName -> System.out.println("param name : " + parameterName));
    System.out.println("[전체 파라미터 조회] END");
    System.out.println();

    System.out.println("[단일 파라미터 조회] START");
    System.out.println(request.getParameter("username"));
    System.out.println(request.getParameter("age"));
    System.out.println("[단일 파라미터 조회] END");
    System.out.println();

    System.out.println("[이름이 같은 복수 파라미터 조회] START");
    String[] usernames = request.getParameterValues("username");
    for (String username : usernames) {
      System.out.println("username = " + username);
    }
    System.out.println("[이름이 같은 복수 파라미터 조회] END");
    System.out.println();

    response.getWriter().write("OK");
  }
}
