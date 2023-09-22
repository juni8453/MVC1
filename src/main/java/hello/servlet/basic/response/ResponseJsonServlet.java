package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Spring MVC 사용하면 설정 코드 다 없앨 수 있음.
    response.setContentType("application/json");

    HelloData helloData = new HelloData();
    helloData.setUsername("KIM");
    helloData.setAge(20);

    // {"username":"KIM", "age":20}
    // 객체 -> JSON 문자
    String result = objectMapper.writeValueAsString(helloData);
    response.getWriter().write(result);
  }
}
