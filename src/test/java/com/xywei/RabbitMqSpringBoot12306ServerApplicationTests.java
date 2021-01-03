package com.xywei;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xywei.domain.Ticket;
import com.xywei.mapper.TicketMapper;

@SpringBootTest
class RabbitMqSpringBoot12306ServerApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private TicketMapper ticketMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDruidConnection() throws Exception {
		System.out.println("class=" + dataSource.getClass());
	}

	@Test
	public void getTicketInfo() {
		Ticket ticket = ticketMapper.ticketFind();
		System.out.println("ticket: " + ticket);
	}
}
