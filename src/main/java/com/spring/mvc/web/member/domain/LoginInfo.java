package com.spring.mvc.web.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class LoginInfo {

    public String account;
    public String password;
    public boolean autoLogin;

}
