# RabbitMQ-SpringBoot-12306-server
## 功能说明
需要结合RabbitMQ-SpringBoot-12306-client
1. 数据库连接只有2个
2. 作为server端，从rabbitmq队列中接收用户请求，用户购买成功，车票减1，并且记录到订单表中
3. 手动确认消息

## 问题
1. 使用rabbitMQ的时候，使用哪种工作模型？  
因为是购票，是完整的业务，所以需要2个exchange，又因为分为接收用户ID和返回用户抢票消息，两条队列，所以需要queue;因此可以选择routing-direct；  
或者，使用默认路由的helloworld，绑定多队列
2. 需要不需要在web服务启动的时候就创建队列？还是用到的时候就创建队列？  
3. 用户抢票了，如何返回用户抢票的结果？如何提醒用户是成功了还是失败了？


## 实践
1. 先实现队列server接收用户抢票信息和返回用户抢票是否成功的信息给client，验证队列是否能流量削峰。
2. 再探讨如何实现用户看到自己抢票的结果！
3. 接着研究exchange在何时创建！
4. 最后优化代码，重构
