package com.example.layeredarchitecture.BO.Impl;

import com.example.layeredarchitecture.BO.Custom.ItemBO;
import com.example.layeredarchitecture.DAO.Custom.ItemDAO;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.Dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean existItems(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public void saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        itemDAO.save(dto);
    }

    @Override
    public void updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        itemDAO.update(dto);
    }

    @Override
    public void deleteItems(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    @Override
    public String generateNextItemID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNextID();
    }

}
