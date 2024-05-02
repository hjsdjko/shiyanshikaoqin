package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 签到
 *
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("qiandao")
public class QiandaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiandaoEntity() {

	}

	public QiandaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "qiandao_time",fill = FieldFill.UPDATE)

    private Date qiandaoTime;


    /**
     * 签退时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qiantui_time",fill = FieldFill.UPDATE)

    private Date qiantuiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Qiandao{" +
            "id=" + id +
            ", yuyueId=" + yuyueId +
            ", qiandaoName=" + qiandaoName +
            ", qiandaoTime=" + qiandaoTime +
            ", qiantuiTime=" + qiantuiTime +
            ", createTime=" + createTime +
        "}";
    }
}
