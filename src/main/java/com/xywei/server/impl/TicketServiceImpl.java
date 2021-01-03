package com.xywei.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xywei.domain.Ticket;
import com.xywei.mapper.TicketMapper;
import com.xywei.server.TicketService;
import com.xywei.vo.UserResult;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public Ticket ticketFind() {
		Ticket ticket = ticketMapper.ticketFind();
		return ticket;
	}

	@Override
	public UserResult Tickethandle(Integer userId) {
		UserResult userResult = null;
		Ticket ticket = ticketMapper.ticketFind();
		if (ticket != null && ticket.getTicketCount() > 0) {
			try {
//				Thread.sleep(2000);
				userResult = new UserResult(userId, "buy ticket success!");
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
