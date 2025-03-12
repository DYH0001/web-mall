import study.kejizhai.bean.*;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.payment;

import java.util.List;

public interface PaymentService {
    PaymentResponse pay(PaymentRequest request) throws PaymentException;
    PaymentNotifyResult handleNotify(Map<String, String> params);
    
    PaymentStatus queryStatus(String orderId);
}

