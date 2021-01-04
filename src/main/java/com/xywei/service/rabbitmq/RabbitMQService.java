package com.xywei.service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xywei.service.TicketService;
import com.xywei.vo.UserResult;

@Component
public class RabbitMQService {

	@Value("${rabbitmq.exchange.com.12306.ticket.client2server}")
	private String exchangeClient2Server;
	@Value("${rabbitmq.routingkey.com.12306.ticket.client2server}")
	private String routingKeyClient2Server;

	@Value("${rabbitmq.exchange.com.12306.ticket.server2client}")
	private String exchangeServer2Client;
	@Value("${rabbitmq.routingkey.com.12306.ticket.server2client}")
	private String routingKeyServer2Client;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private TicketService ticketService;

	/**
	 * 根据exhange/routingkey从RabbitMQ中拿出用户ID
	 * 
	 * @Description
	 * @Datetime 2021年1月4日 下午6:16:25<br/>
	 */
	@RabbitListener(bindings = {
			@QueueBinding(
					value=@Queue, 
					exchange = @Exchange(name ="${rabbitmq.exchange.com.12306.ticket.client2server}", type = "direct"),
					key = {"${rabbitmq.routingkey.com.12306.ticket.client2server}"})
	})
	public void receiveFromRabbitMQ(int userId) {
		// 获取userId，处理逻辑
		UserResult result = ticketService.Tickethandle(userId);
		System.out.println(result);
	}
}
