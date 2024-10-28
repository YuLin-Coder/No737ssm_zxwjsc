package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DetailsDAO;
import com.entity.Details;
import com.service.DetailsService;

@Service("detailsService") //
public class DetailsServiceImpl implements DetailsService { // DetailsServiceImpl 实现了 DetailsService接口

	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private DetailsDAO detailsDAO; // 实现Spring的AOP依赖注入 自动注入AdminDAO接口

	@Override // 继承接口的新增订单明细表数据 返回值0(失败),1(成功)
	public int insertDetails(Details details) {
		return this.detailsDAO.insertDetails(details);
	}

	@Override // 继承接口的更新订单明细表数据 返回值0(失败),1(成功)
	public int updateDetails(Details details) {
		return this.detailsDAO.updateDetails(details);
	}

	@Override // 继承接口的按主键删除订单明细表数据 返回值0(失败),1(成功)
	public int deleteDetails(String detailsid) {
		return this.detailsDAO.deleteDetails(detailsid);
	}

	@Override // 继承接口的批量删除订单明细表数据 返回值0(失败),大于0(成功)
	public int deleteDetailsByIds(String[] ids) {
		return this.detailsDAO.deleteDetailsByIds(ids);
	}

	@Override // 继承接口的查询订单明细表全部数据
	public List<Details> getAllDetails() {
		return this.detailsDAO.getAllDetails();
	}

	@Override // 继承接口的按条件精确查询订单明细表数据
	public List<Details> getDetailsByCond(Details details) {
		return this.detailsDAO.getDetailsByCond(details);
	}

	@Override // 继承接口的按条件模糊查询订单明细表数据
	public List<Details> getDetailsByLike(Details details) {
		return this.detailsDAO.getDetailsByLike(details);
	}

	@Override // 继承接口的按主键查询订单明细表数据 返回Entity实例
	public Details getDetailsById(String detailsid) {
		return this.detailsDAO.getDetailsById(detailsid);
	}

}

