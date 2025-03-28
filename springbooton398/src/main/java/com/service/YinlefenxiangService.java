package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinlefenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinlefenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinlefenxiangView;


/**
 * 音乐分享
 *
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
public interface YinlefenxiangService extends IService<YinlefenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlefenxiangVO> selectListVO(Wrapper<YinlefenxiangEntity> wrapper);
   	
   	YinlefenxiangVO selectVO(@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);
   	
   	List<YinlefenxiangView> selectListView(Wrapper<YinlefenxiangEntity> wrapper);
   	
   	YinlefenxiangView selectView(@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlefenxiangEntity> wrapper);
   	

}

