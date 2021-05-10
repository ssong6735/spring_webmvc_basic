package com.spring.mvc.web.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

// 여러 파라미터의 값을 받는 객체, 반드시 setter, getter 가 있어야 한다.
// 기본 생성자가 없으면 안된다.
// 기본 생성자를 만들지 않으려면 @NoArgsConstructor 사용
@Setter @Getter
@ToString
public class User {

    private String userId;
    private String userPw;
    private String userName;
    private List<String> hobby;

    public User() {
        System.out.println("User 커맨드 객체 생성됨!");
    }

    public void setUserId(String userId) {
        System.out.println("userId setter 호출됨!");
        this.userId = userId;
    }


}
