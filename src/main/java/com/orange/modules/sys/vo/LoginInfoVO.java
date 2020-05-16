package com.orange.modules.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件名称： com.orange.modules.sys.vo.LoginInfoVO.java</br>
 * 初始作者： AirOrangeWorkSpace</br>
 * 创建日期： 2020/5/16 17:15</br>
 * 功能说明： 登录参数 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者        日期       修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2020-2021 .All rights reserved.<br/>
 */
@Data
@ApiModel(value = "登录参数")
public class LoginInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 登录用户名
     */
    @ApiModelProperty(value = "登录用户名")
    private String username;
    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    private String  captcha;

    /**
     * 随机值
     */
    @ApiModelProperty(value = "随机值")
    private String  randomStr;
}
