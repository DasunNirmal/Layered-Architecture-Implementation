package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.SQLUtil;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrderDAO {

    String generateNextOrderID() throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException;

    boolean save(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;

    boolean exitsOrder(String orderId) throws SQLException, ClassNotFoundException;

}
