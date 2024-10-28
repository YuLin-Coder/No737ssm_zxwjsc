package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.DetailsDAO;
import com.dao.GoodsDAO;
import com.dao.OrdersDAO;
import com.dao.TopicDAO;
import com.dao.UsersDAO;
import com.entity.Details;
import com.entity.Goods;
import com.entity.Orders;
import com.entity.Topic;
import com.entity.Users;
import com.util.VeDate;

public class OrdersTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		OrdersDAO ordersDAO = (OrdersDAO) resource.getBean(OrdersDAO.class);
		UsersDAO usersDAO = (UsersDAO) resource.getBean(UsersDAO.class);
		GoodsDAO goodsDAO = (GoodsDAO) resource.getBean(GoodsDAO.class);
		DetailsDAO detailsDAO = (DetailsDAO) resource.getBean(DetailsDAO.class);
		TopicDAO topicDAO = (TopicDAO) resource.getBean(TopicDAO.class);
		List<Users> usersList = usersDAO.getAllUsers();
		for (Users users : usersList) {
			List<Goods> goodsList = goodsDAO.getAllGoods();
			int x = VeDate.getNum(0, goodsList.size() - 1);
			double total = 0;
			String ordersid = VeDate.get32UUID();
			String ordercode = "OD" + VeDate.getStringId() + VeDate.getRandom();
			for (int i = 0; i < 3; i++) {
				int buyNum = VeDate.getNum(1, 5);
				Goods goods = goodsList.get(x);
				Details details = new Details();
				details.setDetailsid(VeDate.get32UUID());
				details.setGoodsid(goods.getGoodsid());
				details.setNum("" + buyNum);
				details.setOrdercode(ordercode);
				details.setPrice(goods.getPrice());
				detailsDAO.insertDetails(details);
				total += VeDate.getDouble(Double.parseDouble(details.getPrice()) * buyNum);
				Topic topic = new Topic();
				topic.setAddtime(VeDate.getNextDay(VeDate.getStringDateShort(), "" + VeDate.getNum(0, x)));
				topic.setContents("contents 评价内容");
				topic.setGoodsid(goods.getGoodsid());
				topic.setOrdercode(ordercode);
				topic.setTopicid(VeDate.get32UUID());
				topic.setUsersid(users.getUsersid());
				topic.setOrdersid(ordersid);
				topic.setNum("" + VeDate.getNum(1, 5));
				topicDAO.insertTopic(topic);
			}
			Orders orders = new Orders();
			orders.setAddress("用户地址");
			orders.setAddtime(VeDate.getNextDay(VeDate.getStringDateShort(), "-" + VeDate.getNum(0, x)));
			orders.setContact(users.getContact());
			orders.setOrdercode(ordercode);
			orders.setOrdersid(ordersid);
			orders.setReceiver(users.getRealname());
			if (x % 3 == 0) {
				orders.setStatus("已付款");
			} else if (x % 5 == 0) {
				orders.setStatus("已发货");
			} else {
				orders.setStatus("确认收货");
			}
			orders.setTotal("" + total);
			orders.setUsersid(users.getUsersid());
			ordersDAO.insertOrders(orders);
		}
	}
}
