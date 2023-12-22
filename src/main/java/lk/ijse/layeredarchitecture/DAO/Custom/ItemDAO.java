package lk.ijse.layeredarchitecture.DAO.Custom;
import lk.ijse.layeredarchitecture.DAO.CrudDAO;
import lk.ijse.layeredarchitecture.Dto.OrderDetailDTO;
import lk.ijse.layeredarchitecture.Entity.Item;

import java.sql.*;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {

    boolean updateItem(List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    boolean updateItems(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

    Item findItem(String code) throws SQLException, ClassNotFoundException;

}
