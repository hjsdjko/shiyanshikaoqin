package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.view.YuyueView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 实验室预约
 * 后端接口
 * @author
 * @email
 * @date 2021-04-09
*/
@RestController
@Controller
@RequestMapping("/yuyue")
public class YuyueController {
    private static final Logger logger = LoggerFactory.getLogger(YuyueController.class);

    @Autowired
    private YuyueService yuyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private ShiyanshiService shiyanshiService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "学生".equals(role)){
            YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
            params.put("yonghuId",request.getSession().getAttribute("userId"));
            params.put("banjiId",userId.getBanjiId());
            params.put("yuyueTypes",1);
        }else if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = yuyueService.queryPage(params);

        //字典表数据转换
        List<YuyueView> list =(List<YuyueView>)page.getList();
        for(YuyueView c:list){
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
        YuyueEntity yuyue = yuyueService.selectById(id);
        if(yuyue !=null){
            //entity转view
            YuyueView view = new YuyueView();
            BeanUtils.copyProperties( yuyue , view );//把实体数据重构到view中

            //级联表
            BanjiEntity banji = banjiService.selectById(yuyue.getBanjiId());
            if(banji != null){
                BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBanjiId(banji.getId());
            }
            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(yuyue.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表
            ShiyanshiEntity shiyanshi = shiyanshiService.selectById(yuyue.getShiyanshiId());
            if(shiyanshi != null){
                BeanUtils.copyProperties( shiyanshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setShiyanshiId(shiyanshi.getId());
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
    public R save(@RequestBody YuyueEntity yuyue, HttpServletRequest request){
//        if(!request.getSession().getAttribute("role").equals("教师")){
//            return R.error("只有教师可以预约");
//        }
        yuyue.setJiaoshiId((Integer) request.getSession().getAttribute("userId"));
        logger.debug("save方法:,,Controller:{},,yuyue:{}",this.getClass().getName(),yuyue.toString());
        Wrapper<YuyueEntity> queryWrapper = new EntityWrapper<YuyueEntity>()
            .eq("shiyanshi_id", yuyue.getShiyanshiId())
            .eq("jiaoshi_id", yuyue.getJiaoshiId())
            .eq("banji_id", yuyue.getBanjiId())
            .eq("yuyue_name", yuyue.getYuyueName())
            .eq("yuyue_types", yuyue.getYuyueTypes())
            .eq("yuyue_yingdao", yuyue.getYuyueYingdao())
            .eq("yuyue_yidao", yuyue.getYuyueYidao())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyueEntity yuyueEntity = yuyueService.selectOne(queryWrapper);
        if(yuyueEntity==null){
            yuyue.setCreateTime(new Date());
            yuyueService.insert(yuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuyueEntity yuyue, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yuyue:{}",this.getClass().getName(),yuyue.toString());
        //根据字段查询是否有相同数据
        Wrapper<YuyueEntity> queryWrapper = new EntityWrapper<YuyueEntity>()
            .notIn("id",yuyue.getId())
            .andNew()
            .eq("shiyanshi_id", yuyue.getShiyanshiId())
            .eq("jiaoshi_id", yuyue.getJiaoshiId())
            .eq("banji_id", yuyue.getBanjiId())
            .eq("yuyue_name", yuyue.getYuyueName())
            .eq("yuyue_types", yuyue.getYuyueTypes())
            .eq("yuyue_yingdao", yuyue.getYuyueYingdao())
            .eq("yuyue_yidao", yuyue.getYuyueYidao())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyueEntity yuyueEntity = yuyueService.selectOne(queryWrapper);
        if(yuyueEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yuyue.set
            //  }
            yuyueService.updateById(yuyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 拒绝
    */
    @RequestMapping("/jujue")
    public R jujue(Integer ids){
        YuyueEntity yuyue = yuyueService.selectById(ids);
        if(yuyue == null){
            return R.error();
        }
        yuyue.setYuyueTypes(2);
        yuyueService.updateById(yuyue);
        return R.ok();
    }
    /**
     * 同意
     */
    @RequestMapping("/tongyi")
    public R tongyi(Integer ids){
        YuyueEntity yuyue = yuyueService.selectById(ids);
        if(yuyue == null){
            return R.error();
        }
        yuyue.setYuyueTypes(1);
        yuyueService.updateById(yuyue);
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
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
        PageUtils page = yuyueService.queryPage(params);

        //字典表数据转换
        List<YuyueView> list =(List<YuyueView>)page.getList();
        for(YuyueView c:list){
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
        YuyueEntity yuyue = yuyueService.selectById(id);
            if(yuyue !=null){
                //entity转view
        YuyueView view = new YuyueView();
                BeanUtils.copyProperties( yuyue , view );//把实体数据重构到view中

                //级联表
                    BanjiEntity banji = banjiService.selectById(yuyue.getBanjiId());
                if(banji != null){
                    BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBanjiId(banji.getId());
                }
                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(yuyue.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                    ShiyanshiEntity shiyanshi = shiyanshiService.selectById(yuyue.getShiyanshiId());
                if(shiyanshi != null){
                    BeanUtils.copyProperties( shiyanshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShiyanshiId(shiyanshi.getId());
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
    public R add(@RequestBody YuyueEntity yuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yuyue:{}",this.getClass().getName(),yuyue.toString());
        Wrapper<YuyueEntity> queryWrapper = new EntityWrapper<YuyueEntity>()
            .eq("shiyanshi_id", yuyue.getShiyanshiId())
            .eq("jiaoshi_id", yuyue.getJiaoshiId())
            .eq("banji_id", yuyue.getBanjiId())
            .eq("yuyue_name", yuyue.getYuyueName())
            .eq("yuyue_types", yuyue.getYuyueTypes())
            .eq("yuyue_yingdao", yuyue.getYuyueYingdao())
            .eq("yuyue_yidao", yuyue.getYuyueYidao())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    YuyueEntity yuyueEntity = yuyueService.selectOne(queryWrapper);
        if(yuyueEntity==null){
            yuyue.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      yuyue.set
        //  }
        yuyueService.insert(yuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

