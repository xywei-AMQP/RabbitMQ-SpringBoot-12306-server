package com.xywei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xywei.server.TicketService;
import com.xywei.vo.UserResult;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/handle/{userId}")
	public UserResult ticketHandle(@PathVariable("userId") Integer userId) {
		UserResult userResult = ticketService.Tickethandle(new Integer(userId));
		return userResult;
	}
}
