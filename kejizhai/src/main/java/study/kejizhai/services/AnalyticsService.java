import study.kejizhai.service.Orderservice;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.review;

import java.util.list;
import static java.lang.Math.*;

public interface AnalyticsService {

    public double calculate_UserRating(List<review> reviews,User user); //用户倾向评价

    public double calculate_UserPrice(List<Items> items,User user); //用户倾向价格

    public double calculate_UserQuantity(List<Orderservice> orders,User user);//购买数量

    public double calculate_UserRepeat_Rate(List<Orderservice> orders,User user);//复购率

    public double calculate_UserRevenue(List<Orderservice> orders,User user); //用户购买总金额

    public double calculate_UserProfit(List<Orderservice> orders,User user); //利润率
    
}


