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
 * 广告设计预览
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-04-26 20:23:17
 */
@TableName("guanggaoshejiyulan")
public class GuanggaoshejiyulanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GuanggaoshejiyulanEntity() {
		
	}
	
	public GuanggaoshejiyulanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 广告名称
	 */
					
	private String guanggaomingcheng;
	
	/**
	 * 广告封面
	 */
					
	private String guanggaofengmian;
	
	/**
	 * 投放渠道
	 */
					
	private String toufangqudao;
	
	/**
	 * 广告要求
	 */
					
	private String guanggaoyaoqiu;
	
	/**
	 * 设计图
	 */
					
	private String shejitu;
	
	/**
	 * 设计图文件
	 */
					
	private String shejituwenjian;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 客户账号
	 */
					
	private String kehuzhanghao;
	
	/**
	 * 客户姓名
	 */
					
	private String kehuxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：广告名称
	 */
	public void setGuanggaomingcheng(String guanggaomingcheng) {
		this.guanggaomingcheng = guanggaomingcheng;
	}
	/**
	 * 获取：广告名称
	 */
	public String getGuanggaomingcheng() {
		return guanggaomingcheng;
	}
	/**
	 * 设置：广告封面
	 */
	public void setGuanggaofengmian(String guanggaofengmian) {
		this.guanggaofengmian = guanggaofengmian;
	}
	/**
	 * 获取：广告封面
	 */
	public String getGuanggaofengmian() {
		return guanggaofengmian;
	}
	/**
	 * 设置：投放渠道
	 */
	public void setToufangqudao(String toufangqudao) {
		this.toufangqudao = toufangqudao;
	}
	/**
	 * 获取：投放渠道
	 */
	public String getToufangqudao() {
		return toufangqudao;
	}
	/**
	 * 设置：广告要求
	 */
	public void setGuanggaoyaoqiu(String guanggaoyaoqiu) {
		this.guanggaoyaoqiu = guanggaoyaoqiu;
	}
	/**
	 * 获取：广告要求
	 */
	public String getGuanggaoyaoqiu() {
		return guanggaoyaoqiu;
	}
	/**
	 * 设置：设计图
	 */
	public void setShejitu(String shejitu) {
		this.shejitu = shejitu;
	}
	/**
	 * 获取：设计图
	 */
	public String getShejitu() {
		return shejitu;
	}
	/**
	 * 设置：设计图文件
	 */
	public void setShejituwenjian(String shejituwenjian) {
		this.shejituwenjian = shejituwenjian;
	}
	/**
	 * 获取：设计图文件
	 */
	public String getShejituwenjian() {
		return shejituwenjian;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：客户账号
	 */
	public void setKehuzhanghao(String kehuzhanghao) {
		this.kehuzhanghao = kehuzhanghao;
	}
	/**
	 * 获取：客户账号
	 */
	public String getKehuzhanghao() {
		return kehuzhanghao;
	}
	/**
	 * 设置：客户姓名
	 */
	public void setKehuxingming(String kehuxingming) {
		this.kehuxingming = kehuxingming;
	}
	/**
	 * 获取：客户姓名
	 */
	public String getKehuxingming() {
		return kehuxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
