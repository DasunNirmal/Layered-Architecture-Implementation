package lk.ijse.layeredarchitecture.DAO.Custom;

import lk.ijse.layeredarchitecture.DAO.CrudDAO;
import lk.ijse.layeredarchitecture.Dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO> {
    boolean saveDetails(List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

}
