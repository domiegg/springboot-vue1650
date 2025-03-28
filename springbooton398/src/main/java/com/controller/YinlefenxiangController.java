package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YinlefenxiangEntity;
import com.entity.view.YinlefenxiangView;

import com.service.YinlefenxiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 音乐分享
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-31 16:09:42
 */
@RestController
@RequestMapping("/yinlefenxiang")
public class YinlefenxiangController {
    @Autowired
    private YinlefenxiangService yinlefenxiangService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlefenxiangEntity yinlefenxiang,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		yinlefenxiang.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinlefenxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YinlefenxiangEntity> ew = new EntityWrapper<YinlefenxiangEntity>();
		PageUtils page = yinlefenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlefenxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlefenxiangEntity yinlefenxiang, 
		HttpServletRequest request){
        EntityWrapper<YinlefenxiangEntity> ew = new EntityWrapper<YinlefenxiangEntity>();
		PageUtils page = yinlefenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlefenxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlefenxiangEntity yinlefenxiang){
       	EntityWrapper<YinlefenxiangEntity> ew = new EntityWrapper<YinlefenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlefenxiang, "yinlefenxiang")); 
        return R.ok().put("data", yinlefenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinlefenxiangEntity yinlefenxiang){
        EntityWrapper< YinlefenxiangEntity> ew = new EntityWrapper< YinlefenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlefenxiang, "yinlefenxiang")); 
		YinlefenxiangView yinlefenxiangView =  yinlefenxiangService.selectView(ew);
		return R.ok("查询音乐分享成功").put("data", yinlefenxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlefenxiangEntity yinlefenxiang = yinlefenxiangService.selectById(id);
		yinlefenxiang.setClicknum(yinlefenxiang.getClicknum()+1);
		yinlefenxiang.setClicktime(new Date());
		yinlefenxiangService.updateById(yinlefenxiang);
        return R.ok().put("data", yinlefenxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlefenxiangEntity yinlefenxiang = yinlefenxiangService.selectById(id);
		yinlefenxiang.setClicknum(yinlefenxiang.getClicknum()+1);
		yinlefenxiang.setClicktime(new Date());
		yinlefenxiangService.updateById(yinlefenxiang);
        return R.ok().put("data", yinlefenxiang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YinlefenxiangEntity yinlefenxiang = yinlefenxiangService.selectById(id);
        if(type.equals("1")) {
        	yinlefenxiang.setThumbsupnum(yinlefenxiang.getThumbsupnum()+1);
        } else {
        	yinlefenxiang.setCrazilynum(yinlefenxiang.getCrazilynum()+1);
        }
        yinlefenxiangService.updateById(yinlefenxiang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlefenxiangEntity yinlefenxiang, HttpServletRequest request){
    	yinlefenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlefenxiang);
    	yinlefenxiang.setUserid((Long)request.getSession().getAttribute("userId"));
        yinlefenxiangService.insert(yinlefenxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlefenxiangEntity yinlefenxiang, HttpServletRequest request){
    	yinlefenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlefenxiang);
        yinlefenxiangService.insert(yinlefenxiang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YinlefenxiangEntity yinlefenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlefenxiang);
        yinlefenxiangService.updateById(yinlefenxiang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlefenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YinlefenxiangEntity> wrapper = new EntityWrapper<YinlefenxiangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yinlefenxiangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YinlefenxiangEntity yinlefenxiang, HttpServletRequest request,String pre){
        EntityWrapper<YinlefenxiangEntity> ew = new EntityWrapper<YinlefenxiangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yinlefenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlefenxiang), params), params));
        return R.ok().put("data", page);
    }







}
