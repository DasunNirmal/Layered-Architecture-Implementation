package com.example.layeredarchitecture.BO.Impl;

import com.example.layeredarchitecture.BO.Custom.CustomerBO;
import com.example.layeredarchitecture.DAO.Custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.Dto.CustomerDTO;
import com.example.layeredarchitecture.Entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        ArrayList<Customer> customers = customerDAO.getAll();

        for (Customer customer : customers) {
            customerDTOS.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public boolean existCustomers(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public void updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }

    @Override
    public String generateNextCustomerID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNextID();
    }
}
