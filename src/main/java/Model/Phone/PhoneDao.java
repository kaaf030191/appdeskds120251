/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Phone;

import Model.DataBaseContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class PhoneDao {
    private DataBaseContext dbc = null;
    private String script = null;
    private int rowsQuantityAfected = 0;
    private List<Phone> listPhone = null;
    private Phone phone = null;
    
    public int insert(Phone phone) throws SQLException {
        this.dbc = new DataBaseContext();

        this.script = "insert into tphone values(?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);

        ps.setString(1, phone.getIdPhone());
        ps.setString(2, phone.getIdPerson());
        ps.setString(3, phone.getIdProvider());
        ps.setString(4, phone.getNumber());
        ps.setTimestamp(5, new java.sql.Timestamp(phone.getCreatedAt().getTime()));
        ps.setTimestamp(6, new java.sql.Timestamp(phone.getUpdatedAt().getTime()));

        this.rowsQuantityAfected = ps.executeUpdate();

        this.dbc.connection.close();

        return rowsQuantityAfected;
    }
}
