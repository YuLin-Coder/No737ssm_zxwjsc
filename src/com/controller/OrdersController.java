package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Orders;
import com.entity.Users;
import com.service.OrdersService;
import com.service.UsersService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/orders", produces = "text/plain;charset=utf-8")
public class OrdersController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UsersService usersService;

	// 通过主键删除数据
	@RequestMapping("deleteOrders.action")
	public String deleteOrders(String id) {
		int i = this.ordersService.deleteOrders(id);
		this.operation("按主键删除订单", i);
		return "redirect:/orders/getAllOrders.action";
	}

	// 批量删除数据
	@RequestMapping("deleteOrdersByIds.action")
	public String deleteOrdersByIds() {
		String[] ids = this.getRequest().getParameterValues("ordersid");
		int i = 0;
		if (ids != null) {
			for (String ordersid : ids) {
				i += this.ordersService.deleteOrders(ordersid);
			}
		}
		this.operation("批量删除订单", i);
		return "redirect:/orders/getAllOrders.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "已发货";
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus(status);
		int i = this.ordersService.updateOrders(orders);
		this.operation("更新订单状态", i);
		return "redirect:/orders/getAllOrders.action";
	}

	// 显示全部数据
	@RequestMapping("getAllOrders.action")
	public String getAllOrders(String number) {
		List<Orders> ordersList = this.ordersService.getAllOrders();
		PageHelper.getUserPage(ordersList, "orders", "getAllOrders", 10, number, this.getRequest());
		this.operation("查看订单数据", 1);
		return "admin/listorders";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryOrdersByCond.action")
	public String queryOrdersByCond(String cond, String name, String number) {
		Orders orders = new Orders();
		if (cond != null) {
			if ("ordercode".equals(cond)) {
				orders.setOrdercode(name);
			}
			if ("usersid".equals(cond)) {
				orders.setUsersid(name);
			}
			if ("total".equals(cond)) {
				orders.setTotal(name);
			}
			if ("status".equals(cond)) {
				orders.setStatus(name);
			}
			if ("addtime".equals(cond)) {
				orders.setAddtime(name);
			}
			if ("receiver".equals(cond)) {
				orders.setReceiver(name);
			}
			if ("address".equals(cond)) {
				orders.setAddress(name);
			}
			if ("contact".equals(cond)) {
				orders.setContact(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ordersService.getOrdersByLike(orders), "orders", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryorders";
	}

	// 按主键查询数据
	@RequestMapping("getOrdersById.action")
	public String getOrdersById(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editorders";
	}

	// 按主键查询数据
	@RequestMapping("queryOrdersById.action")
	public String queryOrdersById(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		this.operation("查看订单数据", 1);
		return "admin/orders";
	}

	// TODO Auto-generated method stub

}
