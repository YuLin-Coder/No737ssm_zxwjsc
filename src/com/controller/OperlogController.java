package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Operlog;
import com.service.OperlogService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/operlog", produces = "text/plain;charset=utf-8")
public class OperlogController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private OperlogService operlogService;

	// TODO Auto-generated method stub

	// 批量删除数据
	@RequestMapping("deleteOperlogByIds.action")
	public String deleteOperlogByIds() {
		String[] ids = this.getRequest().getParameterValues("operlogid");
		if (ids != null) {
			for (String operlogid : ids) {
				this.operlogService.deleteOperlog(operlogid);
			}
		}
		return "redirect:/operlog/getAllOperlog.action";
	}

	// 显示全部数据
	@RequestMapping("getAllOperlog.action")
	public String getAllOperlog(String number) {
		List<Operlog> operlogList = this.operlogService.getAllOperlog();
		PageHelper.getUserPage(operlogList, "operlog", "getAllOperlog", 10, number, this.getRequest());
		return "admin/listoperlog";
	}

	// TODO Auto-generated method stub

}
