package com.entity.view;

import com.entity.JubaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 举报
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
@TableName("jubao")
public class JubaoView  extends JubaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JubaoView(){
	}
 
 	public JubaoView(JubaoEntity jubaoEntity){
 	try {
			BeanUtils.copyProperties(this, jubaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
