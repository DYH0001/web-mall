package study.kejizhai.services.Impl;

import study.kejizhai.services.AnalyticsService;
import study.kejizhai.services.OrderService;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.review;
import org.springframework.stereotype.Service;
import study.kejizhai.bean.Order;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static java.lang.Math.*;
import java.sql.SQLException;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Override
    public double calculate_UserRating(List<review> reviews, Users user) {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        int count = 0;

        for (review r : reviews) {
            if (r.getUid().equals(user.getUid())) {
                totalRating += r.getIreview();
                count++;
            }
        }

        return count > 0 ? totalRating / count : 0.0;
    }

    @Override
    public double calculate_UserPrice(List<Items> items, Users user) {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }

        double totalPrice = 0.0;
        int count = 0;

        for (Items item : items) {
            if (item.getIstatus() == 0) { // 只统计上架商品
                totalPrice += item.getPrice();
                count++;
            }
        }

        return count > 0 ? totalPrice / count : 0.0;
    }

    @Override
    public double calculate_UserQuantity(List<OrderService> orders, Users user) {
        if (orders == null || orders.isEmpty()) {
            return 0.0;
        }

        int totalQuantity = 0;

        for (OrderService orderService : orders) {
            List<Order> userOrders = null;  // 在try块外声明
            try {
                userOrders = orderService.getOrders(user.getUid());
            } catch (SQLException e) {
                e.printStackTrace();
                continue;  // 跳过这次循环继续处理其他订单
            }
            if (userOrders != null) {  // 添加空检查
                for (Order order : userOrders) {
                    if (order.getPayStatus() == 0) { // 已支付订单
                        totalQuantity += order.getOrderItems().size();
                    }
                }
            }
        }

        return (double) totalQuantity;
    }

    @Override
    public double calculate_UserRepeat_Rate(List<OrderService> orders, Users user) {
        if (orders == null || orders.isEmpty()) {
            return 0.0;
        }

        Map<String, Integer> itemPurchaseCount = new HashMap<>();
        int totalItems = 0;
        int repeatedItems = 0;

        for (OrderService orderService : orders) {
            List<Order> userOrders = null;
            try {
                userOrders = orderService.getOrders(user.getUid());
            } catch (SQLException e) {
                e.printStackTrace();
                continue;
            }
            if (userOrders != null) {
                for (Order order : userOrders) {
                    if (order.getPayStatus() == 0) {
                        for (Items item : order.getOrderItems()) {
                            String itemId = item.getIid();
                            itemPurchaseCount.put(itemId, itemPurchaseCount.getOrDefault(itemId, 0) + 1);
                            totalItems++;
                        }
                    }
                }
            }
        }

        for (Integer count : itemPurchaseCount.values()) {
            if (count > 1) {
                repeatedItems += (count - 1);
            }
        }

        return totalItems > 0 ? (double) repeatedItems / totalItems : 0.0;
    }

    @Override
    public double calculate_UserRevenue(List<OrderService> orders, Users user) {
        if (orders == null || orders.isEmpty()) {
            return 0.0;
        }

        double totalRevenue = 0.0;

        for (OrderService orderService : orders) {
            List<Order> userOrders = null;
            try {
                userOrders = orderService.getOrders(user.getUid());
            } catch (SQLException e) {
                e.printStackTrace();
                continue;
            }
            if (userOrders != null) {
                for (Order order : userOrders) {
                    if (order.getPayStatus() == 0) {
                        totalRevenue += order.getTotalPrice();
                    }
                }
            }
        }

        return totalRevenue;
    }

    @Override
    public double calculate_UserProfit(List<OrderService> orders, Users user) {
        if (orders == null || orders.isEmpty()) {
            return 0.0;
        }

        double totalRevenue = calculate_UserRevenue(orders, user);
        double totalCost = 0.0;
        
        // 假设利润率为销售额的20%
        double profitRate = 0.20;
        
        return totalRevenue * profitRate;
    }
}