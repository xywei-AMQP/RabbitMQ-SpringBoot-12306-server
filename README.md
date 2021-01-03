# RabbitMQ-SpringBoot-12306-server
## 功能说明
需要结合RabbitMQ-SpringBoot-12306-client
1. 数据库连接只有2个
2. 作为server端，从rabbitmq队列中接收用户请求，用户购买成功，车票减1，并且记录到订单表中
3. 手动确认消息