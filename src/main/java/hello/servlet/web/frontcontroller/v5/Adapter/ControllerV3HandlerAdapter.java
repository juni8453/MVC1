package hello.servlet.web.frontcontroller.v5.Adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.controller.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ControllerV3 핸들러를 지원하는 Adapter
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

  @Override
  public boolean supports(Object handler) {
    // 넘어온 handler 가 ControllerV3 인가 ?
    return (handler instanceof ControllerV3);
  }

  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws ServletException, IOException {

    ControllerV3 controller = (ControllerV3) handler;
    Map<String, String> paramMap = createParamMap(request);

    // 기존 Front Controller 에서 호출했던 핸들러의 process() 는 어댑터에서 호출하도록 변경
    return controller.process(paramMap);
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator()
        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
    return paramMap;
  }
}
