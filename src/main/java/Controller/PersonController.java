/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Provider.Provider;
import Model.Provider.ProviderDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class PersonController {

    private final ProviderDao providerDao = new ProviderDao();

    public List<Provider> getAll() {
        List<Provider> listProvider = new ArrayList<>();
        
        try {
            listProvider = providerDao.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listProvider;
    }
}
