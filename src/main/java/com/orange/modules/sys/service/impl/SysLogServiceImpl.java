package com.orange.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.modules.sys.entity.SysLog;
import com.orange.modules.sys.mapper.SysLogMapper;
import com.orange.modules.sys.service.SysLogService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper,SysLog> implements SysLogService {

}
