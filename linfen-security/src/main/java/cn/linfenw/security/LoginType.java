package cn.linfenw.security;


import lombok.Getter;

/**
 * @Classname PreAuthenticationSuccessHandler
 * @Description 登录类型 现在有用户名 短信 社交
 * @Author linfen
 * @Date 2019-07-08 13:50
 * @Version 1.0
 */
@Getter
public enum LoginType {
    normal, sms, social;
}
