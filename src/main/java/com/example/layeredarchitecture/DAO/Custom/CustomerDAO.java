package com.example.layeredarchitecture.DAO.Custom;
import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
    CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException;
}
