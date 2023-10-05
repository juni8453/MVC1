package hello.servlet.web.springmvc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/springmvc/old-controller")
public class OldController implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    return null;
  }
}

/**
 * OldController 핸들러를 찾기 위해 핸들러 매핑 에서 찾아야한다. (스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요)
 * 핸들러를 실행할 수 있는 핸들러 어탭터 또한 찾아야한다. (Controller 인터페이스를 실행할 수 있는 핸들러 어탭터가 필요)
 * Spring 은 이미 필요한 핸들러 매핑, 핸들러 어댑터를 대부분 구현해두었다. 찾아서 사용하기만 하면 될 뿐 만들 필요는 거의 없음
 *
 */
