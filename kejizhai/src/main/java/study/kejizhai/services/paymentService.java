import study.kejizhai.bean.*;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.payment;

import java.util.List;

public interface PaymentService {
    public boolean checkPayment(String paymentId, String userId, String amount, String paymentType, String paymentStatus);

    // 创建支付订单
    public payment createPayment(String userId, String amount, String paymentType);

    // 更新支付状态
    public boolean updatePaymentStatus(String paymentId, String paymentStatus);

    // 获取用户支付记录
    public List<payment> getPaymentHistory(String userId);

    // 申请退款
    public boolean refundPayment(String paymentId, String amount, String reason);

    // 根据支付ID获取支付详情
    public payment getPaymentById(String paymentId);
}

