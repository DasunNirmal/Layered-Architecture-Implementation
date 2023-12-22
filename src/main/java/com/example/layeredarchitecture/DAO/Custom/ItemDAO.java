package com.example.layeredarchitecture.DAO.Custom;
import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.Dto.ItemDTO;
import com.example.layeredarchitecture.Dto.OrderDetailDTO;

import java.sql.*;
import java.util.List;

public interface ItemDAO extends CrudDAO<ItemDTO> {

    boolean updateItem(List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    boolean updateItems(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;

}
