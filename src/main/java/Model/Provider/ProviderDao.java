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
            Provider provider = new Provider();

            provider.setIdProvider(rows.getString("idProvider"));
            provider.setName(rows.getString("name"));
            provider.setCreatedAt(rows.getTimestamp("createdAt"));
            provider.setUpdatedAt(rows.getTimestamp("updatedAt"));

            this.listProvider.add(provider);
        }

        this.dbc.connection.close();

        return this.listProvider;
    }
}
