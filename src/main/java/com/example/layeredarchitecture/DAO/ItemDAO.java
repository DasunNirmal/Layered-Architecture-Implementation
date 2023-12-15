package com.example.layeredarchitecture.DAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {

    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    void save(ItemDTO dto) throws SQLException, ClassNotFoundException;

    void update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    void delete(String code) throws SQLException, ClassNotFoundException;

    String generateNextID() throws SQLException, ClassNotFoundException;
}
