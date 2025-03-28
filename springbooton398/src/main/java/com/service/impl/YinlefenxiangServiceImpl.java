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


import com.dao.YinlefenxiangDao;
import com.entity.YinlefenxiangEntity;
import com.service.YinlefenxiangService;
import com.entity.vo.YinlefenxiangVO;
import com.entity.view.YinlefenxiangView;

@Service("yinlefenxiangService")
public class YinlefenxiangServiceImpl extends ServiceImpl<YinlefenxiangDao, YinlefenxiangEntity> implements YinlefenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlefenxiangEntity> page = this.selectPage(
                new Query<YinlefenxiangEntity>(params).getPage(),
                new EntityWrapper<YinlefenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlefenxiangEntity> wrapper) {
		  Page<YinlefenxiangView> page =new Query<YinlefenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YinlefenxiangVO> selectListVO(Wrapper<YinlefenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinlefenxiangVO selectVO(Wrapper<YinlefenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinlefenxiangView> selectListView(Wrapper<YinlefenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlefenxiangView selectView(Wrapper<YinlefenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
