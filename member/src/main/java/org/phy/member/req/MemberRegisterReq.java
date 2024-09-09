package org.phy.member.req;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberRegisterReq {

    @NotBlank(message = "【手机号】不能为空")
    private String mobile;

    private String password;

}
