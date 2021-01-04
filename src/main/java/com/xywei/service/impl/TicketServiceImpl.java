package com.xywei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xywei.domain.Ticket;
import com.xywei.mapper.OrderMapper;
import com.xywei.mapper.TicketMapper;
import com.xywei.service.TicketService;
import com.xywei.vo.UserResult;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketMapper ticketMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Ticket ticketFind() {
		Ticket ticket = ticketMapper.ticketFind();
		return ticket;
	}

	//TODO 事务没有起到作用
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public UserResult Tickethandle(Integer userId) {
		UserResult userResult = null;
		Ticket ticket = ticketMapper.ticketFind();
		if (ticket != null && ticket.getTicketCount() > 0) {
			try {
				ticketMapper.ticketDecrease();
				int insertCount = orderMapper.insertOrderRecord(userId);
//				Thread.sleep(2000);
				userResult = new UserResult(userId, "buy ticket success!" + insertCount);
				System.out.println("ok: " + Thread.currentThread().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			userResult = new UserResult(userId, "sorry!tickets are sell out!");
		}
		return userResult;
	}

}
