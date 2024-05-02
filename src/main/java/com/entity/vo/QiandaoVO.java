package com.entity.vo;

import com.entity.QiandaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 签到
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("qiandao")
public class QiandaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 签到课程
     */

    @TableField(value = "yuyue_id")
    private Integer yuyueId;


    /**
     * 签到人
     */

    @TableField(value = "qiandao_name")
    private String qiandaoName;


    /**
     * 签到时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qiandao_time")
    private Date qiandaoTime;


    /**
     * 签退时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qiantui_time")
    private Date qiantuiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：签到课程
	 */
    public Integer getYuyueId() {
        return yuyueId;
    }


    /**
	 * 获取：签到课程
	 */

    public void setYuyueId(Integer yuyueId) {
        this.yuyueId = yuyueId;
    }
    /**
	 * 设置：签到人
	 */
    public String getQiandaoName() {
        return qiandaoName;
    }


    /**
	 * 获取：签到人
	 */

    public void setQiandaoName(String qiandaoName) {
        this.qiandaoName = qiandaoName;
    }
    /**
	 * 设置：签到时间
	 */
    public Date getQiandaoTime() {
        return qiandaoTime;
    }


    /**
	 * 获取：签到时间
	 */

    public void setQiandaoTime(Date qiandaoTime) {
        this.qiandaoTime = qiandaoTime;
    }
    /**
	 * 设置：签退时间
	 */
    public Date getQiantuiTime() {
        return qiantuiTime;
    }


    /**
	 * 获取：签退时间
	 */

    public void setQiantuiTime(Date qiantuiTime) {
        this.qiantuiTime = qiantuiTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
