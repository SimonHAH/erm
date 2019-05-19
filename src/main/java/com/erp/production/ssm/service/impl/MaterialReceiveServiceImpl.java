package com.erp.production.ssm.service.impl;

import java.util.List;

import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialReceiveVO;
import com.erp.production.ssm.mapper.MaterialReceiveMapper;
import com.erp.production.ssm.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
	
	@Autowired
	private MaterialReceiveMapper materialReceiveMapper;

	@Override
	public PageResult getList(int page, int rows) throws Exception{

		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.find();
		//创建一个返回值对象
		PageResult result = new PageResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(list.size());
		return result;
	}

}
