package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.BO.Impl.CustomerBOImpl;
import com.example.layeredarchitecture.BO.Impl.ItemBOImpl;
import com.example.layeredarchitecture.BO.Impl.PlaceOrderBOImpl;
import com.example.layeredarchitecture.DAO.SuperDAO;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }
    public static BOFactory  getBoFactory () {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes {
        CUSTOMER,ITEM,PLACE_ORDER
    }
    public  SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
