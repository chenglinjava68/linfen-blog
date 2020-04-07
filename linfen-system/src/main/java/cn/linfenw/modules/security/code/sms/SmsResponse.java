package cn.linfenw.modules.security.code.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Classname SmsResponse
 * @Description TODO
 * @Author linfen
 * @Date 2019-08-25 18:42
 * @Version 1.0
 */
@Setter
@Getter
@ToString
public class SmsResponse {

    private String smsPhone;
    private String smsTime;
    private String smsCode;


}
