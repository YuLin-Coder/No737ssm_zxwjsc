package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Details;
import com.service.DetailsService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/details", produces = "text/plain;charset=utf-8")
public class DetailsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private DetailsService detailsService;

	// TODO Auto-generated method stub

	// 显示全部数据
	@RequestMapping("getAllDetails.action")
	public String getAllDetails(String number) {
		List<Details> detailsList = this.detailsService.getAllDetails();
		PageHelper.getUserPage(detailsList, "details", "getAllDetails", 10, number, this.getRequest());
		this.operation("查看订单明细数据", 1);
		return "admin/listdetails";
	}

	// 按主键查询数据
	@RequestMapping("queryDetailsById.action")
	public String queryDetailsById(String id) {
		Details details = this.detailsService.getDetailsById(id);
		this.getRequest().setAttribute("details", details);
		this.operation("查看订单明细数据", 1);
		return "admin/details";
	}

	// TODO Auto-generated method stub

}
