package hello.servlet.web.frontcontroller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {

  private final String viewPath;

  public MyView(String viewPath) {
    this.viewPath = viewPath;
  }

  // MyView 에서 View Rendering 처리 (템플릿 엔진으로 forward 또는 여기서 HTML 만들던지 등)
  public void render(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
  }
}
