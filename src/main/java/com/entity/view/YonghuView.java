package com.entity.view;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("yonghu")
public class YonghuView extends YonghuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 性别的值
		*/
		private String sexValue;



		//级联表 banji
			/**
			* 班级名称
			*/
			private String banjiName;
			/**
			* 班级人数
			*/
			private Integer banjiNumber;

	public YonghuView() {

	}

	public YonghuView(YonghuEntity yonghuEntity) {
		try {
			BeanUtils.copyProperties(this, yonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}




				//级联表的get和set banji
					/**
					* 获取： 班级名称
					*/
					public String getBanjiName() {
						return banjiName;
					}
					/**
					* 设置： 班级名称
					*/
					public void setBanjiName(String banjiName) {
						this.banjiName = banjiName;
					}
					/**
					* 获取： 班级人数
					*/
					public Integer getBanjiNumber() {
						return banjiNumber;
					}
					/**
					* 设置： 班级人数
					*/
					public void setBanjiNumber(Integer banjiNumber) {
						this.banjiNumber = banjiNumber;
					}
















}
