package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerV2 {

  // V1 과는 다르게 void 가 아닌 MyView Type 으로 반환
  MyView process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException;
}
