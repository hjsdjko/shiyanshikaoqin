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
 * 实验室预约
 *
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("yuyue")
public class YuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuyueEntity() {

	}

	public YuyueEntity(T t) {
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
     * 预约实验室
     */
    @TableField(value = "shiyanshi_id")

    private Integer shiyanshiId;


    /**
     * 预约教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 班级
     */
    @TableField(value = "banji_id")

    private Integer banjiId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "yuyue_time",fill = FieldFill.UPDATE)

    private Date yuyueTime;


    /**
     * 所上课程
     */
    @TableField(value = "yuyue_name")

    private String yuyueName;


    /**
     * 是否同意
     */
    @TableField(value = "yuyue_types")

    private Integer yuyueTypes;


    /**
     * 应到人数
     */
    @TableField(value = "yuyue_yingdao")

    private Integer yuyueYingdao;


    /**
     * 已签到人数
     */
    @TableField(value = "yuyue_yidao")

    private Integer yuyueYidao;


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
	 * 设置：预约实验室
	 */
    public Integer getShiyanshiId() {
        return shiyanshiId;
    }


    /**
	 * 获取：预约实验室
	 */

    public void setShiyanshiId(Integer shiyanshiId) {
        this.shiyanshiId = shiyanshiId;
    }
    /**
	 * 设置：预约教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：预约教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiId() {
        return banjiId;
    }


    /**
	 * 获取：班级
	 */

    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：所上课程
	 */
    public String getYuyueName() {
        return yuyueName;
    }


    /**
	 * 获取：所上课程
	 */

    public void setYuyueName(String yuyueName) {
        this.yuyueName = yuyueName;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getYuyueTypes() {
        return yuyueTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setYuyueTypes(Integer yuyueTypes) {
        this.yuyueTypes = yuyueTypes;
    }
    /**
	 * 设置：应到人数
	 */
    public Integer getYuyueYingdao() {
        return yuyueYingdao;
    }


    /**
	 * 获取：应到人数
	 */

    public void setYuyueYingdao(Integer yuyueYingdao) {
        this.yuyueYingdao = yuyueYingdao;
    }
    /**
	 * 设置：已签到人数
	 */
    public Integer getYuyueYidao() {
        return yuyueYidao;
    }


    /**
	 * 获取：已签到人数
	 */

    public void setYuyueYidao(Integer yuyueYidao) {
        this.yuyueYidao = yuyueYidao;
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
        return "Yuyue{" +
            "id=" + id +
            ", shiyanshiId=" + shiyanshiId +
            ", jiaoshiId=" + jiaoshiId +
            ", banjiId=" + banjiId +
            ", yuyueTime=" + yuyueTime +
            ", yuyueName=" + yuyueName +
            ", yuyueTypes=" + yuyueTypes +
            ", yuyueYingdao=" + yuyueYingdao +
            ", yuyueYidao=" + yuyueYidao +
            ", createTime=" + createTime +
        "}";
    }
}
