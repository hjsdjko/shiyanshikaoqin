package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BanjiEntity;
import java.util.Map;

/**
 * 班级 服务类
 * @author 
 * @since 2021-04-09
 */
public interface BanjiService extends IService<BanjiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}