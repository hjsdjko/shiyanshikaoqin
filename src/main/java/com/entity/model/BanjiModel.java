package com.entity.model;

import com.entity.BanjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 班级
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-09
 */
public class BanjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 班级名称
     */
    private String banjiName;


    /**
     * 班级人数
     */
    private Integer banjiNumber;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：班级名称
	 */
    public String getBanjiName() {
        return banjiName;
    }


    /**
	 * 设置：班级名称
	 */
    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }
    /**
	 * 获取：班级人数
	 */
    public Integer getBanjiNumber() {
        return banjiNumber;
    }


    /**
	 * 设置：班级人数
	 */
    public void setBanjiNumber(Integer banjiNumber) {
        this.banjiNumber = banjiNumber;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
