package hello.servlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;
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

  public void render(Map<String, Object> model, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    // Model 의 값을 HttpServletRequest 에 다 담는다.
    // JSP 는 HttpServletRequest 를 사용하니까 어쩔 수 없음.
    modelToRequestAttribute(model, request);
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
  }

  private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
    model.forEach(request::setAttribute);
  }
}
