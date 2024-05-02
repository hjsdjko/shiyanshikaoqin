package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.QiandaoEntity;

import com.service.QiandaoService;
import com.entity.view.QiandaoView;
import com.service.YuyueService;
import com.entity.YuyueEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 签到
 * 后端接口
 * @author
 * @email
 * @date 2021-04-09
*/
@RestController
@Controller
@RequestMapping("/qiandao")
public class QiandaoController {
    private static final Logger logger = LoggerFactory.getLogger(QiandaoController.class);

    @Autowired
    private QiandaoService qiandaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YuyueService yuyueService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = qiandaoService.queryPage(params);

        //字典表数据转换
        List<QiandaoView> list =(List<QiandaoView>)page.getList();
        for(QiandaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QiandaoEntity qiandao = qiandaoService.selectById(id);
        if(qiandao !=null){
            //entity转view
            QiandaoView view = new QiandaoView();
            BeanUtils.copyProperties( qiandao , view );//把实体数据重构到view中

            //级联表
            YuyueEntity yuyue = yuyueService.selectById(qiandao.getYuyueId());
            if(yuyue != null){
                BeanUtils.copyProperties( yuyue , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYuyueId(yuyue.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody QiandaoEntity qiandao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiandao:{}",this.getClass().getName(),qiandao.toString());
        Wrapper<QiandaoEntity> queryWrapper = new EntityWrapper<QiandaoEntity>()
            .eq("yuyue_id", qiandao.getYuyueId())
            .eq("qiandao_name", qiandao.getQiandaoName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiandaoEntity qiandaoEntity = qiandaoService.selectOne(queryWrapper);
        if(qiandaoEntity==null){
            qiandao.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      qiandao.set
        //  }
            qiandaoService.insert(qiandao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiandaoEntity qiandao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qiandao:{}",this.getClass().getName(),qiandao.toString());
        //根据字段查询是否有相同数据
        Wrapper<QiandaoEntity> queryWrapper = new EntityWrapper<QiandaoEntity>()
            .notIn("id",qiandao.getId())
            .andNew()
            .eq("yuyue_id", qiandao.getYuyueId())
            .eq("qiandao_name", qiandao.getQiandaoName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiandaoEntity qiandaoEntity = qiandaoService.selectOne(queryWrapper);
        if(qiandaoEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      qiandao.set
            //  }
            qiandaoService.updateById(qiandao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        qiandaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 签到
     */
    @RequestMapping("/qiandao")
    public R qiandao(Integer ids, HttpServletRequest request){
        YuyueEntity yuyue = yuyueService.selectById(ids);
        if(yuyue == null){
            return R.error();
        }
        if(yuyue.getYuyueTypes() != 1){
            return R.error("只有通过审核的课程才能签到");
        }
        QiandaoEntity qiandao = new QiandaoEntity();
        qiandao.setCreateTime(new Date());
        qiandao.setQiandaoName((String) request.getSession().getAttribute("username"));
        qiandao.setQiandaoTime(new Date());
        qiandao.setYuyueId(ids);
        Wrapper<QiandaoEntity> queryWrapper = new EntityWrapper<QiandaoEntity>()
                .eq("yuyue_id", qiandao.getYuyueId())
                .eq("qiandao_name", qiandao.getQiandaoName())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiandaoEntity qiandaoEntity = qiandaoService.selectOne(queryWrapper);
        if(qiandaoEntity != null){
            return R.error("你已经签到过了");
        }
        boolean insert = qiandaoService.insert(qiandao);
        if(insert){
            yuyue.setYuyueYidao(yuyue.getYuyueYidao()+1);
            yuyueService.updateById(yuyue);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 签退
     */
    @RequestMapping("/qiantui")
    public R qiantui(Integer ids, HttpServletRequest request){
        if(!request.getSession().getAttribute("role").equals("学生")){
            return R.error("只有学生可以签到");
        }
        QiandaoEntity qiandao = qiandaoService.selectOne(new EntityWrapper<QiandaoEntity>()
                .eq("qiandao_name",request.getSession().getAttribute("username"))
                .eq("yuyue_id",ids));
        if(qiandao == null){
            return R.error();
        }
        if(qiandao.getQiantuiTime() != null){
            return R.error("你已经签退过了");
        }
        qiandao.setQiantuiTime(new Date());
        boolean b = qiandaoService.updateById(qiandao);
        if(b){
            return R.ok();
        }
        return R.error();
    }


    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = qiandaoService.queryPage(params);

        //字典表数据转换
        List<QiandaoView> list =(List<QiandaoView>)page.getList();
        for(QiandaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QiandaoEntity qiandao = qiandaoService.selectById(id);
            if(qiandao !=null){
                //entity转view
        QiandaoView view = new QiandaoView();
                BeanUtils.copyProperties( qiandao , view );//把实体数据重构到view中

                //级联表
                    YuyueEntity yuyue = yuyueService.selectById(qiandao.getYuyueId());
                if(yuyue != null){
                    BeanUtils.copyProperties( yuyue , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuyueId(yuyue.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QiandaoEntity qiandao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qiandao:{}",this.getClass().getName(),qiandao.toString());
        Wrapper<QiandaoEntity> queryWrapper = new EntityWrapper<QiandaoEntity>()
            .eq("yuyue_id", qiandao.getYuyueId())
            .eq("qiandao_name", qiandao.getQiandaoName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    QiandaoEntity qiandaoEntity = qiandaoService.selectOne(queryWrapper);
        if(qiandaoEntity==null){
            qiandao.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      qiandao.set
        //  }
        qiandaoService.insert(qiandao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

