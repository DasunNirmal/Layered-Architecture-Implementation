package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements  OrderDetailDAO{

    @Override
    public boolean saveDetails(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        for (OrderDetailDTO dto : orderDetails) {
            if (!save(orderId,dto)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean save(String orderId, OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderId,dto.getItemCode(),dto.getQty(),dto.getUnitPrice());
    }
}
