package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyueEntity;
import java.util.Map;

/**
 * 实验室预约 服务类
 * @author 
 * @since 2021-04-09
 */
public interface YuyueService extends IService<YuyueEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}