package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Loginf;
import com.service.LoginfService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/loginf", produces = "text/plain;charset=utf-8")
public class LoginfController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private LoginfService loginfService;

	// TODO Auto-generated method stub

	// 批量删除数据
	@RequestMapping("deleteLoginfByIds.action")
	public String deleteLoginfByIds() {
		String[] ids = this.getRequest().getParameterValues("loginfid");
		if (ids != null) {
			for (String loginfid : ids) {
				this.loginfService.deleteLoginf(loginfid);
			}
		}
		return "redirect:/loginf/getAllLoginf.action";
	}

	// 显示全部数据
	@RequestMapping("getAllLoginf.action")
	public String getAllLoginf(String number) {
		List<Loginf> loginfList = this.loginfService.getAllLoginf();
		PageHelper.getUserPage(loginfList, "loginf", "getAllLoginf", 10, number, this.getRequest());
		return "admin/listloginf";
	}

	// TODO Auto-generated method stub

}
