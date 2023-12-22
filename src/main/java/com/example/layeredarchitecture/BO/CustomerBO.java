package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {

    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean existCustomers(String id) throws SQLException, ClassNotFoundException;
}
