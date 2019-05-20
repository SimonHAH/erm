package com.erp.production.ssm.service.material;

import com.erp.production.ssm.bean.MaterialConsume;
import com.erp.production.ssm.bean.MaterialConsumeExample;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.material.MaterialConsumeVO;
import com.erp.production.ssm.mapper.MaterialConsumeMapper;
import com.erp.production.ssm.service.material.MaterialConsumeService;
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

	@Override
	public PageResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue) {
		PageHelper.startPage(page,rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByConsumeId(searchValue);
		PageResult pageResult = new PageResult();
		pageResult.setRows(list);
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

	@Override
	public PageResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue) {
		PageHelper.startPage(page,rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByMaterialId(searchValue);
		PageResult pageResult = new PageResult();
		pageResult.setRows(list);
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

	@Override
	public PageResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue) {
		PageHelper.startPage(page,rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByWorkId(searchValue);
		PageResult pageResult = new PageResult();
		pageResult.setRows(list);
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

    @Override
    public CustomResult updateNote(MaterialConsume materialConsume){
        // TODO Auto-generated method stub
        int i = materialConsumeMapper.updateNote(materialConsume);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改物料消耗备注失败");
        }
    }

    @Override
    public MaterialConsume get(String id){
        // TODO Auto-generated method stub
        return materialConsumeMapper.selectByPrimaryKey(id);
    }
    @Override
    public CustomResult insert(MaterialConsume materialConsume){
        // TODO Auto-generated method stub
        int i = materialConsumeMapper.insert(materialConsume);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增物料消耗信息失败");
        }
    }
    @Override
    public CustomResult updateAll(MaterialConsume materialConsume){
        // TODO Auto-generated method stub
        int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改物料消耗信息失败");
        }
    }
    @Override
    public CustomResult deleteBatch(String[] ids){
        // TODO Auto-generated method stub
        int i = materialConsumeMapper.deleteBatch(ids);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }
}

