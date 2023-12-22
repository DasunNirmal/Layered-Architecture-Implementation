package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.Dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO> {
    boolean saveDetails(List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

}
