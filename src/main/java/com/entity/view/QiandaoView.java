package com.entity.view;

import com.entity.QiandaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 签到
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("qiandao")
public class QiandaoView extends QiandaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 yuyue
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
				* 是否同意的值
				*/
				private String yuyueValue;
			/**
			* 应到人数
			*/
			private Integer yuyueYingdao;
			/**
			* 已签到人数
			*/
			private Integer yuyueYidao;

	public QiandaoView() {

	}

	public QiandaoView(QiandaoEntity qiandaoEntity) {
		try {
			BeanUtils.copyProperties(this, qiandaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





















				//级联表的get和set yuyue
					/**
					* 获取： 预约实验室
					*/
					public Integer getShiyanshiId() {
						return shiyanshiId;
					}
					/**
					* 设置： 预约实验室
					*/
					public void setShiyanshiId(Integer shiyanshiId) {
						this.shiyanshiId = shiyanshiId;
					}
					/**
					* 获取： 预约教师
					*/
					public Integer getJiaoshiId() {
						return jiaoshiId;
					}
					/**
					* 设置： 预约教师
					*/
					public void setJiaoshiId(Integer jiaoshiId) {
						this.jiaoshiId = jiaoshiId;
					}
					/**
					* 获取： 班级
					*/
					public Integer getBanjiId() {
						return banjiId;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiId(Integer banjiId) {
						this.banjiId = banjiId;
					}
					/**
					* 获取： 预约时间
					*/
					public Date getYuyueTime() {
						return yuyueTime;
					}
					/**
					* 设置： 预约时间
					*/
					public void setYuyueTime(Date yuyueTime) {
						this.yuyueTime = yuyueTime;
					}
					/**
					* 获取： 所上课程
					*/
					public String getYuyueName() {
						return yuyueName;
					}
					/**
					* 设置： 所上课程
					*/
					public void setYuyueName(String yuyueName) {
						this.yuyueName = yuyueName;
					}
					/**
					* 获取： 是否同意
					*/
					public Integer getYuyueTypes() {
						return yuyueTypes;
					}
					/**
					* 设置： 是否同意
					*/
					public void setYuyueTypes(Integer yuyueTypes) {
						this.yuyueTypes = yuyueTypes;
					}


						/**
						* 获取： 是否同意的值
						*/
						public String getYuyueValue() {
							return yuyueValue;
						}
						/**
						* 设置： 是否同意的值
						*/
						public void setYuyueValue(String yuyueValue) {
							this.yuyueValue = yuyueValue;
						}
					/**
					* 获取： 应到人数
					*/
					public Integer getYuyueYingdao() {
						return yuyueYingdao;
					}
					/**
					* 设置： 应到人数
					*/
					public void setYuyueYingdao(Integer yuyueYingdao) {
						this.yuyueYingdao = yuyueYingdao;
					}
					/**
					* 获取： 已签到人数
					*/
					public Integer getYuyueYidao() {
						return yuyueYidao;
					}
					/**
					* 设置： 已签到人数
					*/
					public void setYuyueYidao(Integer yuyueYidao) {
						this.yuyueYidao = yuyueYidao;
					}


}
