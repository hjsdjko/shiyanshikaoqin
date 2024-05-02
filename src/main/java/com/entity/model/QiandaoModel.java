package com.entity.model;

import com.entity.QiandaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 签到
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-09
 */
public class QiandaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 签到课程
     */
    private Integer yuyueId;


    /**
     * 签到人
     */
    private String qiandaoName;


    /**
     * 签到时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qiandaoTime;


    /**
     * 签退时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qiantuiTime;


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
	 * 获取：签到课程
	 */
    public Integer getYuyueId() {
        return yuyueId;
    }


    /**
	 * 设置：签到课程
	 */
    public void setYuyueId(Integer yuyueId) {
        this.yuyueId = yuyueId;
    }
    /**
	 * 获取：签到人
	 */
    public String getQiandaoName() {
        return qiandaoName;
    }


    /**
	 * 设置：签到人
	 */
    public void setQiandaoName(String qiandaoName) {
        this.qiandaoName = qiandaoName;
    }
    /**
	 * 获取：签到时间
	 */
    public Date getQiandaoTime() {
        return qiandaoTime;
    }


    /**
	 * 设置：签到时间
	 */
    public void setQiandaoTime(Date qiandaoTime) {
        this.qiandaoTime = qiandaoTime;
    }
    /**
	 * 获取：签退时间
	 */
    public Date getQiantuiTime() {
        return qiantuiTime;
    }


    /**
	 * 设置：签退时间
	 */
    public void setQiantuiTime(Date qiantuiTime) {
        this.qiantuiTime = qiantuiTime;
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
