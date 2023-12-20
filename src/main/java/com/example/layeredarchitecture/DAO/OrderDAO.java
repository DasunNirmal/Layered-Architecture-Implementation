package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends CrudDAO <OrderDTO> {

    String generateNextID() throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException;

    boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

    boolean exist(String orderId) throws SQLException, ClassNotFoundException;

}
