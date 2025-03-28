package com.dao;

import com.entity.YinlefenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinlefenxiangVO;
import com.entity.view.YinlefenxiangView;


/**
 * 音乐分享
 * 
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
public interface YinlefenxiangDao extends BaseMapper<YinlefenxiangEntity> {
	
	List<YinlefenxiangVO> selectListVO(@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);
	
	YinlefenxiangVO selectVO(@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);
	
	List<YinlefenxiangView> selectListView(@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);

	List<YinlefenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);
	
	YinlefenxiangView selectView(@Param("ew") Wrapper<YinlefenxiangEntity> wrapper);
	

}
