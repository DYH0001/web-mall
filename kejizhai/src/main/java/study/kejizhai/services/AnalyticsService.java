package study.kejizhai.services;

import study.kejizhai.services.OrderService;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.review;

import java.util.List;
import static java.lang.Math.*;

public interface AnalyticsService {

    public double calculate_UserRating(List<review> reviews,Users user); //用户倾向评价

    public double calculate_UserPrice(List<Items> items,Users user); //用户倾向价格

    public double calculate_UserQuantity(List<OrderService> orders,Users user);//购买数量

    public double calculate_UserRepeat_Rate(List<OrderService> orders,Users user);//复购率

    public double calculate_UserRevenue(List<OrderService> orders,Users user); //用户购买总金额

    public double calculate_UserProfit(List<OrderService> orders,Users user); //利润率
    
}


