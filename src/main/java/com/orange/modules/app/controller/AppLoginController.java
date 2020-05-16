package com.orange.modules.app.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orange.common.base.AbstractController;
import com.orange.common.utils.R;
import com.orange.modules.sys.entity.SysUser;
import com.orange.modules.sys.service.SysUserService;
import com.orange.modules.sys.service.SysUserTokenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "App登录API",value = "登陆接口")
@RestController
@RequestMapping("/")

public class AppLoginController  extends AbstractController {
	@Autowired
	private  SysUserService sysUserService;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private  SysUserTokenService sysUserTokenService;
	
	@ApiOperation(value = "登陆")
    @RequestMapping(value = "/app/sys/login",method = RequestMethod.POST)
    public R getUserId(@ApiParam(value = "用户名",required = true)@RequestParam(value = "username",required = true)String username,
            		   @ApiParam(value = "密码",required = true)@RequestParam(value = "password",required = true)String password){
		// 用户信息
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		SysUser user = sysUserService.getOne(queryWrapper);

		// 账号不存在、密码错误
		if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			return R.error("账号已被锁定,请联系管理员");
		}
		//生成token
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		
		
		return R.ok();
    }
	
}
