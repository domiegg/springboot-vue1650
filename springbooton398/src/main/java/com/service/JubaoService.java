package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JubaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JubaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JubaoView;


/**
 * 举报
 *
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
public interface JubaoService extends IService<JubaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JubaoVO> selectListVO(Wrapper<JubaoEntity> wrapper);
   	
   	JubaoVO selectVO(@Param("ew") Wrapper<JubaoEntity> wrapper);
   	
   	List<JubaoView> selectListView(Wrapper<JubaoEntity> wrapper);
   	
   	JubaoView selectView(@Param("ew") Wrapper<JubaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JubaoEntity> wrapper);
   	

}

