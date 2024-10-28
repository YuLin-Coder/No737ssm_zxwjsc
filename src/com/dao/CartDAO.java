package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Cart;

@Repository("cartDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到CartServiceImpl中
public interface CartDAO {


	/**
	* CartDAO 接口 可以按名称直接调用cart.xml配置文件的SQL语句
	*/


	// 插入购物车表数据 调用mapper包cart.xml里的insertCart配置 返回值0(失败),1(成功)
	public int insertCart(Cart cart);

	// 更新购物车表数据 调用mapper包cart.xml里的updateCart配置 返回值0(失败),1(成功)
	public int updateCart(Cart cart);

	// 按主键删除购物车表数据 调用mapper包cart.xml里的deleteCart配置 返回值0(失败),1(成功)
	public int deleteCart(String cartid);

	// 批量删除购物车表数据 调用mapper包cart.xml里的deleteCartByIds配置 返回值0(失败),大于0(成功)
	public int deleteCartByIds(String[] ids);

	// 查询购物车表全部数据 调用mapper包cart.xml里的getAllCart配置 返回List<Cart>类型的数据
	public List<Cart> getAllCart();

	// 按照Cart类里面的值精确查询 调用mapper包cart.xml里的getCartByCond配置 返回List<Cart>类型的数据
	public List<Cart> getCartByCond(Cart cart);

	// 按照Cart类里面的值模糊查询 调用mapper包cart.xml里的getCartByLike配置 返回List<Cart>类型的数据
	public List<Cart> getCartByLike(Cart cart);

	// 按主键查询购物车表返回单一的Cart实例 调用mapper包cart.xml里的getCartById配置
	public Cart getCartById(String cartid);

}


