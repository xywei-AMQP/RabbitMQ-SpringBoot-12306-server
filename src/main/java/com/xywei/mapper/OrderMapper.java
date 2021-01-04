package com.xywei.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	int insertOrderRecord(int userId);
}
