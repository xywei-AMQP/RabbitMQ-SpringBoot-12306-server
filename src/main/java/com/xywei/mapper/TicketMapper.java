package com.xywei.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.xywei.domain.Ticket;

@Mapper
public interface TicketMapper {

	Ticket ticketFind();
}
