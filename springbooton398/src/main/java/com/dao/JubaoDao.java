package com.dao;

import com.entity.JubaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JubaoVO;
import com.entity.view.JubaoView;


/**
 * 举报
 * 
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
public interface JubaoDao extends BaseMapper<JubaoEntity> {
	
	List<JubaoVO> selectListVO(@Param("ew") Wrapper<JubaoEntity> wrapper);
	
	JubaoVO selectVO(@Param("ew") Wrapper<JubaoEntity> wrapper);
	
	List<JubaoView> selectListView(@Param("ew") Wrapper<JubaoEntity> wrapper);

	List<JubaoView> selectListView(Pagination page,@Param("ew") Wrapper<JubaoEntity> wrapper);
	
	JubaoView selectView(@Param("ew") Wrapper<JubaoEntity> wrapper);
	

}
