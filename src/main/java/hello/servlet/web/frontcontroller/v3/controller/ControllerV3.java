package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import java.util.Map;

public interface ControllerV3 {

  // ControllerV2 와는 다르게 서블릿 기술을 사용 X
  ModelView process(Map<String, String> paramMap);

}
