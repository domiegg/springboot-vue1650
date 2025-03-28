package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyinlefenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyinlefenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyinlefenxiangView;


/**
 * 音乐分享评论表
 *
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
public interface DiscussyinlefenxiangService extends IService<DiscussyinlefenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinlefenxiangVO> selectListVO(Wrapper<DiscussyinlefenxiangEntity> wrapper);
   	
   	DiscussyinlefenxiangVO selectVO(@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);
   	
   	List<DiscussyinlefenxiangView> selectListView(Wrapper<DiscussyinlefenxiangEntity> wrapper);
   	
   	DiscussyinlefenxiangView selectView(@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinlefenxiangEntity> wrapper);
   	

}

