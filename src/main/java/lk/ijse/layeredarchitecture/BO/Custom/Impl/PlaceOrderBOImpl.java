package lk.ijse.layeredarchitecture.BO.Custom.Impl;

import lk.ijse.layeredarchitecture.BO.Custom.PlaceOrderBO;
import lk.ijse.layeredarchitecture.DAO.Custom.CustomerDAO;
import lk.ijse.layeredarchitecture.DAO.Custom.ItemDAO;
import lk.ijse.layeredarchitecture.DAO.Custom.OrderDAO;
import lk.ijse.layeredarchitecture.DAO.Custom.OrderDetailDAO;
import lk.ijse.layeredarchitecture.DAO.DAOFactory;
import lk.ijse.layeredarchitecture.db.DBConnection;
import lk.ijse.layeredarchitecture.Dto.CustomerDTO;
import lk.ijse.layeredarchitecture.Dto.ItemDTO;
import lk.ijse.layeredarchitecture.Dto.OrderDTO;
import lk.ijse.layeredarchitecture.Dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    OrderDetailDAO orderDetailImpl = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException {
        /*Transaction*/
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();
            boolean isExist = orderDAO.exist(orderId);
            /*if order id already exist*/
            if (isExist) {
                return false;
            }

            connection.setAutoCommit(false);

            /*Refactored*/
            boolean isSaved = orderDAO.save(new OrderDTO(orderId,orderDate,customerId));
            if (isSaved) {
                boolean isOrderDetailSaved = orderDetailImpl.saveDetails(orderDetails);
                if (isOrderDetailSaved) {
                    boolean isUpdated = itemDAO.updateItem(orderDetails);
                    if (isUpdated) {
                        connection.commit();
                    }
                }
            }
            connection.rollback();
            connection.setAutoCommit(true);
            return true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomer(id);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean existItems(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public ItemDTO findItems(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.findItem(code);
    }

    @Override
    public String generateNextOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNextID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}
