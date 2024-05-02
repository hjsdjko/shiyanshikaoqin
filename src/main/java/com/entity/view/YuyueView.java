package com.entity.view;

import com.entity.YuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 实验室预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-09
 */
@TableName("yuyue")
public class YuyueView extends YuyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否同意的值
		*/
		private String yuyueValue;



		//级联表 banji
			/**
			* 班级名称
			*/
			private String banjiName;
			/**
			* 班级人数
			*/
			private Integer banjiNumber;

		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 手机号
			*/
			private String jiaoshiPhone;
			/**
			* 照片
			*/
			private String jiaoshiPhoto;

		//级联表 shiyanshi
			/**
			* 实验室名称
			*/
			private String shiyanshiName;
			/**
			* 实验室位置
			*/
			private String shiyanshiWeizhi;
			/**
			* 实验室图片
			*/
			private String shiyanshiPhoto;
			/**
			* 实验室详情
			*/
			private String shiyanshiContent;

	public YuyueView() {

	}

	public YuyueView(YuyueEntity yuyueEntity) {
		try {
			BeanUtils.copyProperties(this, yuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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







				//级联表的get和set jiaoshi
					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
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
					/**
					* 获取： 身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}











				//级联表的get和set shiyanshi
					/**
					* 获取： 实验室名称
					*/
					public String getShiyanshiName() {
						return shiyanshiName;
					}
					/**
					* 设置： 实验室名称
					*/
					public void setShiyanshiName(String shiyanshiName) {
						this.shiyanshiName = shiyanshiName;
					}
					/**
					* 获取： 实验室位置
					*/
					public String getShiyanshiWeizhi() {
						return shiyanshiWeizhi;
					}
					/**
					* 设置： 实验室位置
					*/
					public void setShiyanshiWeizhi(String shiyanshiWeizhi) {
						this.shiyanshiWeizhi = shiyanshiWeizhi;
					}
					/**
					* 获取： 实验室图片
					*/
					public String getShiyanshiPhoto() {
						return shiyanshiPhoto;
					}
					/**
					* 设置： 实验室图片
					*/
					public void setShiyanshiPhoto(String shiyanshiPhoto) {
						this.shiyanshiPhoto = shiyanshiPhoto;
					}
					/**
					* 获取： 实验室详情
					*/
					public String getShiyanshiContent() {
						return shiyanshiContent;
					}
					/**
					* 设置： 实验室详情
					*/
					public void setShiyanshiContent(String shiyanshiContent) {
						this.shiyanshiContent = shiyanshiContent;
					}














}
