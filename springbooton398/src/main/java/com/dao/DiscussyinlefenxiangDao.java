package com.dao;

import com.entity.DiscussyinlefenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyinlefenxiangVO;
import com.entity.view.DiscussyinlefenxiangView;


/**
 * 音乐分享评论表
 * 
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
public interface DiscussyinlefenxiangDao extends BaseMapper<DiscussyinlefenxiangEntity> {
	
	List<DiscussyinlefenxiangVO> selectListVO(@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);
	
	DiscussyinlefenxiangVO selectVO(@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);
	
	List<DiscussyinlefenxiangView> selectListView(@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);

	List<DiscussyinlefenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);
	
	DiscussyinlefenxiangView selectView(@Param("ew") Wrapper<DiscussyinlefenxiangEntity> wrapper);
	

}
