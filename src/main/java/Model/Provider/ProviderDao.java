/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Provider;

import Model.DataBaseContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class ProviderDao {

    private DataBaseContext dbc = null;
    private String script = null;
    private int rowsQuantityAfected = 0;
    private List<Provider> listProvider = null;
    private Provider provider = null;

    public int insert(Provider provider) throws SQLException {
        this.dbc = new DataBaseContext();

        this.script = "insert into tprovider values(?, ?, ?, ?)";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);

        ps.setString(1, provider.getIdProvider());
        ps.setString(2, provider.getName());
        ps.setTimestamp(3, new java.sql.Timestamp(provider.getCreatedAt().getTime()));
        ps.setTimestamp(4, new java.sql.Timestamp(provider.getUpdatedAt().getTime()));

        this.rowsQuantityAfected = ps.executeUpdate();

        this.dbc.connection.close();

        return rowsQuantityAfected;
    }

    public List<Provider> getAll() throws SQLException {
        this.dbc = new DataBaseContext();

        this.listProvider = new ArrayList<>();

        this.script = "select * from tprovider";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);

        ResultSet rows = ps.executeQuery();

        while (rows.next()) {
            Provider providerTemp = new Provider();

            providerTemp.setIdProvider(rows.getString("idProvider"));
            providerTemp.setName(rows.getString("name"));
            providerTemp.setCreatedAt(rows.getTimestamp("createdAt"));
            providerTemp.setUpdatedAt(rows.getTimestamp("updatedAt"));

            this.listProvider.add(providerTemp);
        }

        this.dbc.connection.close();

        return this.listProvider;
    }
    
    public Provider getByName(String name) throws SQLException {
        this.dbc = new DataBaseContext();

        this.script = "select * from tprovider where name = ?";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);
        
        ps.setString(1, name);

        ResultSet rows = ps.executeQuery();

        if (rows.next()) {
            this.provider = new Provider();

            this.provider.setIdProvider(rows.getString("idProvider"));
            this.provider.setName(rows.getString("name"));
            this.provider.setCreatedAt(rows.getTimestamp("createdAt"));
            this.provider.setUpdatedAt(rows.getTimestamp("updatedAt"));
        }

        this.dbc.connection.close();

        return this.provider;
    }
}
