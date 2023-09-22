package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

/*
  JSON 형식으로 파싱하기 위한 클래스
*/
@Getter
@Setter
public class HelloData {

  private String username;
  private int age;

}
