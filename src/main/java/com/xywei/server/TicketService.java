package com.xywei.server;

import com.xywei.domain.Ticket;
import com.xywei.vo.UserResult;

public interface TicketService {
	
	Ticket ticketFind();

	UserResult Tickethandle(Integer userId);

}
