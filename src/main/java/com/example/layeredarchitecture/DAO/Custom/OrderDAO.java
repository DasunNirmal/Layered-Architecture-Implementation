package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.Dto.OrderDTO;

import java.sql.*;

public interface OrderDAO extends CrudDAO<OrderDTO> {

    boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

}
