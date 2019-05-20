package com.erp.production.ssm.service.impl;

import com.erp.production.ssm.bean.MaterialConsume;
import com.erp.production.ssm.bean.MaterialConsumeExample;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;
import com.erp.production.ssm.mapper.MaterialConsumeMapper;
import com.erp.production.ssm.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

	@Autowired
	MaterialConsumeMapper materialConsumeMapper;
	
	@Override
	public List<MaterialConsume> find() throws Exception{
		// TODO Auto-generated method stub
		MaterialConsumeExample example = new MaterialConsumeExample();
		return materialConsumeMapper.selectByExample(example);
	}

	@Override
	public PageResult getList(int page, int rows, MaterialConsumeVO materialConsume)
			throws Exception{
		// TODO Auto-generated method stub
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.find(materialConsume);
		//创建一个返回值对象
		PageResult result = new PageResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
