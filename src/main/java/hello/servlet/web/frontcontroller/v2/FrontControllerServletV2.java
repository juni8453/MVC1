package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

  private final Map<String, ControllerV2> controllerMap = new HashMap<>();

  // URL 매핑 정보 를 담아둔다.
  public FrontControllerServletV2() {
    controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
    controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
    controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /*
      1. HTTP 요청에 담긴 URI 추출
      2. 미리 URI 매핑 정보를 담은 Map 에서 해당되는 Controller 추출
      3. 해당 Controller 에 Servlet 의 Request, Response 를 보내 MyView 객체를 추출
      4. MyView 의 render() 를 사용해서 View Rendering
    */
    String requestURI = request.getRequestURI();
    ControllerV2 controller = controllerMap.get(requestURI);
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    // 각 컨트롤러에서 처리하던 View Rendering 을 프론트 컨트롤러에서 MyView 로 위임함으로써 통합적으로 처리
    MyView view = controller.process(request, response);
    view.render(request, response);
  }
}
