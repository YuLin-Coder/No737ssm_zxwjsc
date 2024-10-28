package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LoginfDAO;
import com.entity.Loginf;
import com.service.LoginfService;

@Service("loginfService") //
public class LoginfServiceImpl implements LoginfService { // LoginfServiceImpl 实现了 LoginfService接口

	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private LoginfDAO loginfDAO; // 实现Spring的AOP依赖注入 自动注入AdminDAO接口

	@Override // 继承接口的新增登录日志表数据 返回值0(失败),1(成功)
	public int insertLoginf(Loginf loginf) {
		return this.loginfDAO.insertLoginf(loginf);
	}

	@Override // 继承接口的更新登录日志表数据 返回值0(失败),1(成功)
	public int updateLoginf(Loginf loginf) {
		return this.loginfDAO.updateLoginf(loginf);
	}

	@Override // 继承接口的按主键删除登录日志表数据 返回值0(失败),1(成功)
	public int deleteLoginf(String loginfid) {
		return this.loginfDAO.deleteLoginf(loginfid);
	}

	@Override // 继承接口的批量删除登录日志表数据 返回值0(失败),大于0(成功)
	public int deleteLoginfByIds(String[] ids) {
		return this.loginfDAO.deleteLoginfByIds(ids);
	}

	@Override // 继承接口的查询登录日志表全部数据
	public List<Loginf> getAllLoginf() {
		return this.loginfDAO.getAllLoginf();
	}

	@Override // 继承接口的按条件精确查询登录日志表数据
	public List<Loginf> getLoginfByCond(Loginf loginf) {
		return this.loginfDAO.getLoginfByCond(loginf);
	}

	@Override // 继承接口的按条件模糊查询登录日志表数据
	public List<Loginf> getLoginfByLike(Loginf loginf) {
		return this.loginfDAO.getLoginfByLike(loginf);
	}

	@Override // 继承接口的按主键查询登录日志表数据 返回Entity实例
	public Loginf getLoginfById(String loginfid) {
		return this.loginfDAO.getLoginfById(loginfid);
	}

}

