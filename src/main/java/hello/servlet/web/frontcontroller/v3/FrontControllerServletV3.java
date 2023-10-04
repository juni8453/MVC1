package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

  private final Map<String, ControllerV3> controllerMap = new HashMap<>();

  // URL 매핑 정보 를 담아둔다.
  public FrontControllerServletV3() {
    controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
    controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
    controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /*
      1. HTTP 요청에 담긴 URI 추출
      2. 미리 URI 매핑 정보를 담은 Map 에서 해당되는 Controller 추출
      3. HttpServletRequest 에서 요청 정보를 뽑아 Map<String, String> paramMap 에 삽입
      4. 서블릿 종속이 제거된 컨트롤러의 process() 의 인자로 paramMap 을 넘겨 viewName, model 필드를 가진 ModelView 객체 추출
      5. ViewResolver() 에 ModelView 객체를 인자로 넘겨 MyView 객체 추출
      6. MyView 의 render() 실시, 이 때 Rendering 에는 Model 이 필요하므로 같이 넘겨줌
    */
    String requestURI = request.getRequestURI();
    ControllerV3 controller = controllerMap.get(requestURI);
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    Map<String, String> paramMap = createParamMap(request);
    ModelView modelView = controller.process(paramMap);
    MyView view = viewResolver(modelView);
    view.render(modelView.getModel(), request, response);
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator()
        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
    return paramMap;
  }

  private MyView viewResolver(ModelView modelView) {
    return new MyView("/WEB-INF/views/" + modelView.getViewName() + ".jsp");
  }
}
