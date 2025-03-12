import study.kejizhai.bean.*;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.payment;

import java.util.List;

public interface PaymentService {
    public boolean checkPayment(String paymentId, String userId, String amount, String paymentType, String paymentStatus);

    public boolean processPayment(String paymentId, String userId, String amount, String paymentType);
    
    public boolean refundPayment(String paymentId, String userId, String amount);
    
    public payment getPaymentById(String paymentId);
    
    public List<payment> getPaymentsByUserId(String userId);
    
    public boolean updatePaymentStatus(String paymentId, String paymentStatus);
}

