package com.cloud.bssp.data.config.generator;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface GenMapper {
 
	@Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables  where table_schema = (SELECT DATABASE()) and table_name = #{tableName}")
	Map<String, Object> queryTable(String tableName);
 
	@Select("select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns  where table_name =#{tableName} and table_schema = (SELECT DATABASE())  order by ordinal_position")
	List<Map<String, Object>> queryColumns(String tableName);
 
	@Select("select table_name tableName from information_schema.tables  where table_schema = (SELECT DATABASE())")
	List<String> queryAllTable();
}