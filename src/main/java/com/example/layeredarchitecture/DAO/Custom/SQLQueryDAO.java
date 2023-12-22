package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.SuperDAO;
import com.example.layeredarchitecture.Dto.OrderSummary;
import java.sql.SQLException;

public interface SQLQueryDAO extends SuperDAO {

    OrderSummary OrderDetails() throws SQLException, ClassNotFoundException;

}
