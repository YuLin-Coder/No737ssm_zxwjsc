<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>管理员信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/createAdmin.action" data-title="新增管理员" href="javascript:void(0)">新增管理员信息</a></li>
					<li><a data-href="admin/getAllAdmin.action" data-title="管理员列表" href="javascript:void(0)">管理员信息列表</a></li>
					<li><a data-href="admin/queryAdminByCond.action" data-title="管理员查询" href="javascript:void(0)">管理员信息查询</a></li>
					<li><a data-href="admin/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="users/getAllUsers.action" data-title="网站用户列表" href="javascript:void(0)">网站用户信息列表</a></li>
					<li><a data-href="users/queryUsersByCond.action" data-title="网站用户查询" href="javascript:void(0)">网站用户信息查询</a></li>
					<li><a data-href="chart/preChartUser.action" data-title="网站用户统计" href="javascript:void(0)">网站用户统计</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>新闻公告信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="article/createArticle.action" data-title="新增新闻公告" href="javascript:void(0)">新增新闻公告信息</a></li>
					<li><a data-href="article/getAllArticle.action" data-title="新闻公告列表" href="javascript:void(0)">新闻公告信息列表</a></li>
					<li><a data-href="article/queryArticleByCond.action" data-title="新闻公告查询" href="javascript:void(0)">新闻公告信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>商品类型信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="cate/createCate.action" data-title="新增商品类型" href="javascript:void(0)">新增商品类型信息</a></li>
					<li><a data-href="cate/getAllCate.action" data-title="商品类型列表" href="javascript:void(0)">商品类型信息列表</a></li>
					<li><a data-href="cate/queryCateByCond.action" data-title="商品类型查询" href="javascript:void(0)">商品类型信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>商品信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="goods/createGoods.action" data-title="新增商品" href="javascript:void(0)">新增商品信息</a></li>
					<li><a data-href="goods/getAllGoods.action" data-title="商品列表" href="javascript:void(0)">商品信息列表</a></li>
					<li><a data-href="goods/queryGoodsByCond.action" data-title="商品查询" href="javascript:void(0)">商品信息查询</a></li>
					<li><a data-href="chart/preCate.action" data-title="分类销量统计" href="javascript:void(0)">分类销量统计</a></li>
				</ul>
			</dd>
		</dl>


		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>订单信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getAllOrders.action" data-title="订单列表" href="javascript:void(0)">订单信息列表</a></li>
					<li><a data-href="orders/queryOrdersByCond.action" data-title="订单查询" href="javascript:void(0)">订单信息查询</a></li>
					<li><a data-href="chart/preChartOrders.action" data-title="订单统计" href="javascript:void(0)">订单统计</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>订单评价信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="topic/getAllTopic.action" data-title="订单评价列表" href="javascript:void(0)">订单评价信息列表</a></li>
					<li><a data-href="topic/queryTopicByCond.action" data-title="订单评价查询" href="javascript:void(0)">订单评价信息查询</a></li>
					<li><a data-href="chart/preChartTopic.action" data-title="用户评价统计" href="javascript:void(0)">用户评价统计</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>意见反馈信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="complains/getAllComplains.action" data-title="意见反馈列表" href="javascript:void(0)">意见反馈信息列表</a></li>
					<li><a data-href="complains/queryComplainsByCond.action" data-title="意见反馈查询" href="javascript:void(0)">意见反馈信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>日志信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="loginf/getAllLoginf.action" data-title="登录日志列表" href="javascript:void(0)">登录日志信息列表</a></li>
					<li><a data-href="operlog/getAllOperlog.action" data-title="操作日志列表" href="javascript:void(0)">操作日志信息列表</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>


