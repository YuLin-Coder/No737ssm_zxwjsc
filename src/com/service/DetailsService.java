package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Details;
@Service("detailsService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface DetailsService {

	// 插入订单明细表数据 调用detailsDAO里的insertDetails配置
	public int insertDetails(Details details);

	// 更新订单明细表数据 调用detailsDAO里的updateDetails配置
	public int updateDetails(Details details);

	// 按主键删除订单明细表数据 调用detailsDAO里的deleteDetails配置
	public int deleteDetails(String detailsid);

	// 批量删除订单明细表数据 调用mapper包details.xml里的deleteDetailsByIds配置 返回值0(失败),大于0(成功)
	public int deleteDetailsByIds(String[] ids);

	// 查询全部数据 调用detailsDAO里的getAllDetails配置
	public List<Details> getAllDetails();

	// 按照Details类里面的字段名称精确查询 调用detailsDAO里的getDetailsByCond配置
	public List<Details> getDetailsByCond(Details details);

	// 按照Details类里面的字段名称模糊查询 调用detailsDAO里的getDetailsByLike配置
	public List<Details> getDetailsByLike(Details details);

	// 按主键查询表返回单一的Details实例 调用detailsDAO里的getDetailsById配置
	public Details getDetailsById(String detailsid);

}

