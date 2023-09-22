package hello.servlet.basic.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class HttpServletRequest extends HttpServlet {

  @Override
  protected void service(javax.servlet.http.HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    System.out.println("--- [REQUEST LINE] START ---");
    System.out.println(request.getMethod());
    System.out.println(request.getRequestURL());
    System.out.println(request.getRequestURI());
    System.out.println(request.getQueryString());
    System.out.println(request.isSecure()); // HTTP 인가 HTTPS 인가
    System.out.println("--- [REQUEST LINE] END ---");

    System.out.println("--- [HEADER] START ---");
    request.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(
        "headerName = " + headerName));
    System.out.println("--- [HEADER] END ---");

    System.out.println("--- [HOST] START ---");
    System.out.println(request.getServerName());
    System.out.println(request.getServerPort());
    System.out.println("--- [HOST] END ---");

    System.out.println("[Accept-Language] START");
    request.getLocales().asIterator()
            .forEachRemaining(local -> System.out.println("local = " + local));
    System.out.println("[Accept-Language] END");

    System.out.println("[Cookie] START");
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        System.out.println(cookie.getName() + ": " + cookie.getValue());
      }
    }
    System.out.println("[Cookie] END");

    System.out.println("[Content] START");
    System.out.println(request.getContentType());
    System.out.println(request.getContentLength());
    System.out.println(request.getContentLengthLong());
    System.out.println("[Content] END");
  }
}
