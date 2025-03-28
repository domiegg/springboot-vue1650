package com.entity.view;

import com.entity.YinlefenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 音乐分享
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
@TableName("yinlefenxiang")
public class YinlefenxiangView  extends YinlefenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinlefenxiangView(){
	}
 
 	public YinlefenxiangView(YinlefenxiangEntity yinlefenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, yinlefenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
