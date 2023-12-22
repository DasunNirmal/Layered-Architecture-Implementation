package com.example.layeredarchitecture.DAO.Custom;
import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.Dto.CustomerDTO;
import com.example.layeredarchitecture.Entity.Customer;

import java.sql.*;

public interface CustomerDAO extends CrudDAO<Customer> {
    Customer getCustomer(String id) throws SQLException, ClassNotFoundException;
}
