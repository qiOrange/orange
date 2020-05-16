package com.orange.modules.apkversion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.modules.apkversion.entity.ApkVersion;
import com.orange.modules.apkversion.mapper.ApkVersionMapper;
import com.orange.modules.apkversion.service.ApkVersionService;

import org.springframework.stereotype.Service;



@Service
public class ApkVersionServiceImpl extends ServiceImpl<ApkVersionMapper, ApkVersion> implements ApkVersionService {
	
}
