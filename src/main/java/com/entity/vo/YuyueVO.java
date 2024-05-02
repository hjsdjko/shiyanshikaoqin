package com.entity.vo;

import com.entity.YuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 实验室预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("yuyue")
public class YuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "yuyue_time")
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

}
