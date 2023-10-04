package hello.servlet.web.frontcontroller.v4.controller;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

  // V3 와 다르게 ModelView 를 구현 Controller 에서 만들 필요가 없다.
  @Override
  public String process(Map<String, String> paramMap, Map<String, Object> model) {
    return "new-form";
  }
}
