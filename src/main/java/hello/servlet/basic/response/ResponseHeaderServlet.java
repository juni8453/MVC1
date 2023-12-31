package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // [Statue-Line]
    response.setStatus(HttpServletResponse.SC_OK);

    // [Response Header]
    response.setHeader("Content-Type", "text/plain;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("my-header", "hello");

    // [Cookie]
    Cookie cookie = new Cookie("myCookie", "good");
    cookie.setMaxAge(600);
    response.addCookie(cookie);

    // [Redirect]
    //    response.setStatus(HttpServletResponse.SC_FOUND);
    //    response.setHeader("Location", "/basic/hello-form.html");

    // [편리한 Redirect]
    response.sendRedirect("/basic/hello-form.html");

    PrintWriter writer = response.getWriter();
    writer.println("OK");
  }
}
