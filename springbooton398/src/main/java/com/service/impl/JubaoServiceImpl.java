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


import com.dao.JubaoDao;
import com.entity.JubaoEntity;
import com.service.JubaoService;
import com.entity.vo.JubaoVO;
import com.entity.view.JubaoView;

@Service("jubaoService")
public class JubaoServiceImpl extends ServiceImpl<JubaoDao, JubaoEntity> implements JubaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JubaoEntity> page = this.selectPage(
                new Query<JubaoEntity>(params).getPage(),
                new EntityWrapper<JubaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JubaoEntity> wrapper) {
		  Page<JubaoView> page =new Query<JubaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JubaoVO> selectListVO(Wrapper<JubaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JubaoVO selectVO(Wrapper<JubaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JubaoView> selectListView(Wrapper<JubaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JubaoView selectView(Wrapper<JubaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
