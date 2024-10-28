package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.GoodsDAO;
import com.entity.Goods;
import com.util.VeDate;

public class GoodsTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		GoodsDAO goodsDAO = (GoodsDAO) resource.getBean(GoodsDAO.class);
		// TODO Auto-generated method stub
		List<Goods> goodsList = goodsDAO.getAllGoods();
		int i = 0;
		for (Goods goods : goodsList) {
			goods.setSellnum("" + VeDate.getRandom());
			goods.setHits("" + VeDate.getRandom());
			if (i % 7 == 0) {
				goods.setSpecial("是");
			} else {
				goods.setSpecial("否");
			}
			if (i % 3 == 0) {
				goods.setRecommend("否");
			} else {
				goods.setRecommend("是");
			}
			goodsDAO.updateGoods(goods);
			i++;
		}
	}

}
