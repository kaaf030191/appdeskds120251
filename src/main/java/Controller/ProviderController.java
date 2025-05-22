/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Provider.Provider;
import Model.Provider.ProviderDao;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author KAAF0
 */
public class ProviderController {
    private final ProviderDao providerDao = new ProviderDao();
    
    public boolean insert(Provider provider) {
        try {
            provider.setIdProvider(UUID.randomUUID().toString());
            provider.setCreatedAt(new Date());
            provider.setUpdatedAt(provider.getCreatedAt());
            
            this.providerDao.insert(provider);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return true;
    }
}
