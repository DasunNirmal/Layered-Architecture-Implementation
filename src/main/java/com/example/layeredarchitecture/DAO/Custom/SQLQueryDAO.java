package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.DAO.SuperDAO;
import com.example.layeredarchitecture.model.OrderSummary;
import java.sql.SQLException;

public interface SQLQueryDAO extends SuperDAO {

    OrderSummary OrderDetails() throws SQLException, ClassNotFoundException;

}
