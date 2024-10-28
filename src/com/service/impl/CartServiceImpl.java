package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CartDAO;
import com.entity.Cart;
import com.service.CartService;

@Service("cartService") //
public class CartServiceImpl implements CartService { // CartServiceImpl 实现了 CartService接口

	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private CartDAO cartDAO; // 实现Spring的AOP依赖注入 自动注入AdminDAO接口

	@Override // 继承接口的新增购物车表数据 返回值0(失败),1(成功)
	public int insertCart(Cart cart) {
		return this.cartDAO.insertCart(cart);
	}

	@Override // 继承接口的更新购物车表数据 返回值0(失败),1(成功)
	public int updateCart(Cart cart) {
		return this.cartDAO.updateCart(cart);
	}

	@Override // 继承接口的按主键删除购物车表数据 返回值0(失败),1(成功)
	public int deleteCart(String cartid) {
		return this.cartDAO.deleteCart(cartid);
	}

	@Override // 继承接口的批量删除购物车表数据 返回值0(失败),大于0(成功)
	public int deleteCartByIds(String[] ids) {
		return this.cartDAO.deleteCartByIds(ids);
	}

	@Override // 继承接口的查询购物车表全部数据
	public List<Cart> getAllCart() {
		return this.cartDAO.getAllCart();
	}

	@Override // 继承接口的按条件精确查询购物车表数据
	public List<Cart> getCartByCond(Cart cart) {
		return this.cartDAO.getCartByCond(cart);
	}

	@Override // 继承接口的按条件模糊查询购物车表数据
	public List<Cart> getCartByLike(Cart cart) {
		return this.cartDAO.getCartByLike(cart);
	}

	@Override // 继承接口的按主键查询购物车表数据 返回Entity实例
	public Cart getCartById(String cartid) {
		return this.cartDAO.getCartById(cartid);
	}

}

