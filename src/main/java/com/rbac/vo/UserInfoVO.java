package com.rbac.vo;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserInfoVO {



    private Long userId;


    private String username;

    private String password;


    private Long orgId;

    //@NotBlank(message = "不能为null")
    private String orgName;




}
