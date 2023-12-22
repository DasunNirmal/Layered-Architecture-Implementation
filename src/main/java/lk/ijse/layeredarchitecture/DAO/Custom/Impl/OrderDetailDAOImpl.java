package lk.ijse.layeredarchitecture.DAO.Custom.Impl;

import lk.ijse.layeredarchitecture.DAO.Custom.OrderDetailDAO;
import lk.ijse.layeredarchitecture.DAO.SQLUtil;
import lk.ijse.layeredarchitecture.Dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean saveDetails(List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        for (OrderDetailDTO dto : orderDetails) {
            if (!save(dto)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNextID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
