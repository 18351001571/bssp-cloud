package com.cloud.bssp.generator.dao;

import com.cloud.bssp.generator.entity.TableColumnDO;
import com.cloud.bssp.generator.entity.TableDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description: 代码生成mapper
 *
 * Created date: 2020/7/15
 * @author weirx
 */
@Mapper
public interface GenerateMapper {

    /**
     * Description: 根据表名获取表信息
     * Created date: 2020/7/15
     * @param tableName 表名
     * @return java.util.Map<com.cloud.bssp.generator.entity.TableDO>
     * @author weirx
     */
    @Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables  where table_schema = (SELECT DATABASE()) and table_name = #{tableName}")
    TableDO queryTable(String tableName);

    /**
     * Description: 根据表名获取表字段
     * Created date: 2020/7/15
     * @param tableName 表名
     * @return java.util.List<com.cloud.bssp.generator.entity.TableColumnDO>
     * @author weirx
     */
    @Select("select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns  where table_name =#{tableName} and table_schema = (SELECT DATABASE())  order by ordinal_position")
    List<TableColumnDO> queryColumns(String tableName);

    /**
     * Description: 获取全部表
     * Created date: 2020/7/15
     * @return java.util.List<com.cloud.bssp.generator.entity.TableColumnDO>
     * @author weirx
     */
    @Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables  where table_schema = (SELECT DATABASE())")
    List<TableDO> queryAllTable();

    /**
     * 根据tableName获取数量
     *
     * @param tableName
     * @return
     */
    @Select("select count(*) from information_schema.tables  where table_schema = (SELECT DATABASE()) " +
			"and table_name = #{tableName}")
    int count(String tableName);

    /**
     * 根据tableName获取数量
     *
     * @return
     */
    @Select("select count(*) from information_schema.tables  where table_schema = (SELECT DATABASE())")
    int countAll();

    /**
     * Description: 根据表名分页
     * Created date: 2020/7/15
     * @param tableName
     * @param offset
     * @param limit
     * @return java.util.List<com.cloud.bssp.generator.entity.TableDO>
     * @author weirx
     */
    @Select("select table_name tableName, engine, table_comment tableComment, " +
			"create_time createTime from information_schema.tables  where table_schema = (SELECT DATABASE()) " +
			"and table_name = #{tableName} limit #{offset} , #{limit} ")
    List<TableDO> pageList(String tableName, long offset, long limit);

    /**
     * Description: 全部数据分页
     * Created date: 2020/7/15
     * @param offset
     * @param limit
     * @return java.util.List<com.cloud.bssp.generator.entity.TableDO>
     * @author weirx
     */
    @Select("select table_name tableName, engine, table_comment tableComment, " +
			"create_time createTime from information_schema.tables  where table_schema = (SELECT DATABASE()) " +
			"limit #{offset} , #{limit}")
    List<TableDO> pageListAll(long offset, long limit);
}