package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyinlefenxiangDao;
import com.entity.DiscussyinlefenxiangEntity;
import com.service.DiscussyinlefenxiangService;
import com.entity.vo.DiscussyinlefenxiangVO;
import com.entity.view.DiscussyinlefenxiangView;

@Service("discussyinlefenxiangService")
public class DiscussyinlefenxiangServiceImpl extends ServiceImpl<DiscussyinlefenxiangDao, DiscussyinlefenxiangEntity> implements DiscussyinlefenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinlefenxiangEntity> page = this.selectPage(
                new Query<DiscussyinlefenxiangEntity>(params).getPage(),
                new EntityWrapper<DiscussyinlefenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinlefenxiangEntity> wrapper) {
		  Page<DiscussyinlefenxiangView> page =new Query<DiscussyinlefenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyinlefenxiangVO> selectListVO(Wrapper<DiscussyinlefenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyinlefenxiangVO selectVO(Wrapper<DiscussyinlefenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyinlefenxiangView> selectListView(Wrapper<DiscussyinlefenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinlefenxiangView selectView(Wrapper<DiscussyinlefenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
