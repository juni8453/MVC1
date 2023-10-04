package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

  // 핸들러(컨트롤러)가 넘어왔을 때 이 핸들러를 지원할 수 있는지 판단하는 메서드
  boolean supports(Object handler);

  ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws ServletException, IOException;
}
