package com.entity.model;

import com.entity.YuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实验室预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-09
 */
public class YuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约实验室
     */
    private Integer shiyanshiId;


    /**
     * 预约教师
     */
    private Integer jiaoshiId;


    /**
     * 班级
     */
    private Integer banjiId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 所上课程
     */
    private String yuyueName;


    /**
     * 是否同意
     */
    private Integer yuyueTypes;


    /**
     * 应到人数
     */
    private Integer yuyueYingdao;


    /**
     * 已签到人数
     */
    private Integer yuyueYidao;


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
	 * 获取：预约实验室
	 */
    public Integer getShiyanshiId() {
        return shiyanshiId;
    }


    /**
	 * 设置：预约实验室
	 */
    public void setShiyanshiId(Integer shiyanshiId) {
        this.shiyanshiId = shiyanshiId;
    }
    /**
	 * 获取：预约教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：预约教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：班级
	 */
    public Integer getBanjiId() {
        return banjiId;
    }


    /**
	 * 设置：班级
	 */
    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：所上课程
	 */
    public String getYuyueName() {
        return yuyueName;
    }


    /**
	 * 设置：所上课程
	 */
    public void setYuyueName(String yuyueName) {
        this.yuyueName = yuyueName;
    }
    /**
	 * 获取：是否同意
	 */
    public Integer getYuyueTypes() {
        return yuyueTypes;
    }


    /**
	 * 设置：是否同意
	 */
    public void setYuyueTypes(Integer yuyueTypes) {
        this.yuyueTypes = yuyueTypes;
    }
    /**
	 * 获取：应到人数
	 */
    public Integer getYuyueYingdao() {
        return yuyueYingdao;
    }


    /**
	 * 设置：应到人数
	 */
    public void setYuyueYingdao(Integer yuyueYingdao) {
        this.yuyueYingdao = yuyueYingdao;
    }
    /**
	 * 获取：已签到人数
	 */
    public Integer getYuyueYidao() {
        return yuyueYidao;
    }


    /**
	 * 设置：已签到人数
	 */
    public void setYuyueYidao(Integer yuyueYidao) {
        this.yuyueYidao = yuyueYidao;
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
