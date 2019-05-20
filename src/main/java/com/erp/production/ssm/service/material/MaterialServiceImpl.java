package com.erp.production.ssm.service.material;
import com.erp.production.ssm.bean.Material;
import com.erp.production.ssm.bean.MaterialExample;
import com.erp.production.ssm.bean.customize.CustomResult;
import com.erp.production.ssm.bean.customize.PageResult;
import com.erp.production.ssm.bean.customize.ResponseVo;
import com.erp.production.ssm.mapper.MaterialMapper;
import com.erp.production.ssm.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    public List<Material> find() throws Exception{
        MaterialExample example = new MaterialExample();
        return materialMapper.selectByExample(example);
    }

    @Override
    public ResponseVo getList(Integer page, Integer rows, Material material) {
        //查询列表
        MaterialExample example = new MaterialExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<Material> list = materialMapper.selectByExample(example);
        //创建一个返回值对象
        ResponseVo result = new ResponseVo();
        result.setRows(list);
        //取记录总条数
        PageInfo<Material> pageInfo = new PageInfo<>(list);

        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public PageResult searchMaterialByMaterialId(Integer page, Integer rows, String materialId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Material> list = materialMapper.searchMaterialByMaterialId(materialId);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public PageResult searchMaterialByMaterialType(Integer page, Integer rows, String materialType) {
        //分页处理
        PageHelper.startPage(page,rows);
        List<Material> list = materialMapper.searchMaterialByMaterialType(materialType);
        //创建一个返回值对象
        PageResult result = new PageResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public CustomResult updateNote(Material material) {
        int i = materialMapper.updateByPrimaryKeySelective(material);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改物料信息失败");
        }
    }

    @Override
    public CustomResult updateAll(Material material) {
        int i = materialMapper.updateByPrimaryKey(material);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "修改物料信息失败");
        }
    }

    @Override
    public Material get(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    public CustomResult insert(Material material){
        int i = materialMapper.insert(material);
        if(i>0){
            return CustomResult.ok();
        }else{
            return CustomResult.build(101, "新增物料信息失败");
        }
    }
    @Override
    public CustomResult deleteBatch(String[] ids){
        int i = materialMapper.deleteBatch(ids);
        if(i>0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }
}
