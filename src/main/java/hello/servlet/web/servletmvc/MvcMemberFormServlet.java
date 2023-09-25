package hello.servlet.web.servletmvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

  /*
  * 1. 고객 요청 -> service() 호출
  * 2. JSP 파일 찾아서 Dispatcher 가 호출
  * forward 는 서버 내부에서 일어나는 호출, 클라이언트에서 다시 호출 X
  * */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String viewPath = "/WEB-INF/views/new-form.jsp";
    // Controller -> View 로 이동하기 위함

    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
  }
}
