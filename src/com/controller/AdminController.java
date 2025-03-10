package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Admin;
import com.service.AdminService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/admin", produces = "text/plain;charset=utf-8")
public class AdminController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private AdminService adminService;

	// TODO Auto-generated method stub

	// 管理员准备登录
	@RequestMapping("index.action")
	public String index() {
		String year = VeDate.getYear();
		this.getRequest().setAttribute("year", year);
		return "admin/index";
	}

	// 管理员欢迎页
	@RequestMapping("welcome.action")
	public String welcome() {
		return "admin/welcome";
	}

	// 管理员登录 1 验证用户名是否存在 2 验证密码是否正确
	@RequestMapping("login.action")
	public String login() {
		String username = this.getRequest().getParameter("username"); // 定义一个username变量 接收jsp传递来的用户名数据
		String password = this.getRequest().getParameter("password"); // 定义一个password变量 接收jsp传递来的密码数据
		Admin adminEntity = new Admin(); // 实例化一个管理员对象
		adminEntity.setUsername(username); // 为管理员对象中的username属性赋值
		List<Admin> adminlist = this.adminService.getAdminByCond(adminEntity);
		if (adminlist.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			this.loginfo(username, "非法用户", 0);
			return "redirect:/admin/index.action";
		} else {
			Admin admin = adminlist.get(0); // 取得查询结果的第一行数据
			if (password.equals(admin.getPassword())) { // 判断用户输入的密码和数据表中的密码是否一致
				// 用session保存管理员的信息
				this.getSession().setAttribute("adminid", admin.getAdminid());
				this.getSession().setAttribute("adminname", admin.getUsername());
				this.getSession().setAttribute("realname", admin.getRealname());
				this.getSession().setAttribute("role", "管理员");
				this.loginfo(username, "管理员", 1);
			} else {
				this.getSession().setAttribute("message", "密码错误");
				this.loginfo(username, "非法用户", 0);
				return "redirect:/admin/index.action";
			}
		}
		return "admin/main";
	}

	// 管理员准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		return "admin/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String password = this.getRequest().getParameter("password");// 获取JSP 输入的旧密码
		String repassword = this.getRequest().getParameter("repassword");// 获取JSP 输入的新密码
		Admin admin = this.adminService.getAdminById(adminid);
		int i = 0;
		if (password.equals(admin.getPassword())) { // 判断旧密码与数据表中的密码是否一致
			admin.setPassword(repassword); // 把新密码赋值给admin 对象
			i = this.adminService.updateAdmin(admin);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
		}
		this.operation("修改密码", i);
		return "redirect:/admin/prePwd.action"; // redirect 重定向 跳转返回到准备修改密码
	}

	// 管理员退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.getSession().removeAttribute("adminid");
		this.getSession().removeAttribute("adminname");
		this.getSession().removeAttribute("realname");
		this.getSession().removeAttribute("role");
		return "redirect:/admin/index.action";
	}

	// 准备添加数据
	@RequestMapping("createAdmin.action")
	public String createAdmin() {
		return "admin/addadmin";
	}

	// 添加数据
	@RequestMapping("addAdmin.action")
	public String addAdmin(Admin admin) {
		admin.setAddtime(VeDate.getStringDateShort());
		int i = this.adminService.insertAdmin(admin);
		this.operation("新增管理员", i);
		return "redirect:/admin/createAdmin.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteAdmin.action")
	public String deleteAdmin(String id) {
		int i = this.adminService.deleteAdmin(id);
		this.operation("按主键删除管理员", i);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 批量删除数据
	@RequestMapping("deleteAdminByIds.action")
	public String deleteAdminByIds() {
		String[] ids = this.getRequest().getParameterValues("adminid");
		int i = 0;
		if (ids != null) {
			for (String adminid : ids) {
				i += this.adminService.deleteAdmin(adminid);
			}
		}
		this.operation("批量删除管理员", i);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 更新数据
	@RequestMapping("updateAdmin.action")
	public String updateAdmin(Admin admin) {
		int i = this.adminService.updateAdmin(admin);
		this.operation("修改管理员", i);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 显示全部数据
	@RequestMapping("getAllAdmin.action")
	public String getAllAdmin(String number) {
		List<Admin> adminList = this.adminService.getAllAdmin();
		PageHelper.getUserPage(adminList, "admin", "getAllAdmin", 10, number, this.getRequest());
		this.operation("查看管理员数据", 1);
		return "admin/listadmin";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryAdminByCond.action")
	public String queryAdminByCond(String cond, String name, String number) {
		Admin admin = new Admin();
		if (cond != null) {
			if ("username".equals(cond)) {
				admin.setUsername(name);
			}
			if ("password".equals(cond)) {
				admin.setPassword(name);
			}
			if ("realname".equals(cond)) {
				admin.setRealname(name);
			}
			if ("contact".equals(cond)) {
				admin.setContact(name);
			}
			if ("addtime".equals(cond)) {
				admin.setAddtime(name);
			}
		}
		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.adminService.getAdminByLike(admin), "admin", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryadmin";
	}

	// 按主键查询数据
	@RequestMapping("getAdminById.action")
	public String getAdminById(String id) {
		Admin admin = this.adminService.getAdminById(id);
		this.getRequest().setAttribute("admin", admin);
		return "admin/editadmin";
	}

	// 按主键查询数据
	@RequestMapping("queryAdminById.action")
	public String queryAdminById(String id) {
		Admin admin = this.adminService.getAdminById(id);
		this.getRequest().setAttribute("admin", admin);
		this.operation("查看管理员数据", 1);
		return "admin/admin";
	}

	// TODO Auto-generated method stub

}
