package hello.servlet.web.frontcontroller.v5.Adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.controller.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ControllerV4 핸들러를 지원하는 Adapter
public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

  @Override
  public boolean supports(Object handler) {
    // 넘어온 handler 가 ControllerV4 인가 ?
    return (handler instanceof ControllerV4);
  }

  // V3 와 다르게 controller.process(paramMap, model); 가 반환하는 것은 String Type 의 viewName 이다.
  // Adapter 패턴의 장점을 여기서 확인할 수 있음. 다양한 방식으로 ModelView 를 채우고 반환할 수 있는 것.
  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws ServletException, IOException {

    ControllerV4 controller = (ControllerV4) handler;

    Map<String, String> paramMap = createParamMap(request);
    Map<String, Object> model = new HashMap<>();

    String viewName = controller.process(paramMap, model);

    ModelView modelView = new ModelView(viewName);
    modelView.setModel(model);

    return modelView;
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator()
        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

    return paramMap;
  }
}
