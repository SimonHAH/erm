package com.erp.production.ssm.mapper;

import com.erp.production.ssm.bean.plan.Task;
import com.erp.production.ssm.bean.plan.TaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    //自己拓展的方法
    List<Task> find();

    List<Task> searchTaskByTaskId(@Param("taskId") String taskId);

    List<Task> searchTaskByTaskWorkId(@Param("workId") String workId);

    List<Task> searchTaskByTaskManufactureSn(@Param("manufactureSn") String manufactureSn);

    //逆向工程生产的方法
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);


}