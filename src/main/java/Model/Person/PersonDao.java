/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Person;

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
public class PersonDao {

    private DataBaseContext dbc = null;
    private String script = null;
    private int rowsQuantityAfected = 0;
    private List<Person> listPerson = null;
    private Person person = null;

    public int insert(Person person) throws SQLException {
        this.dbc = new DataBaseContext();

        this.script = "insert into tperson values(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);

        ps.setString(1, person.getIdPerson());
        ps.setString(2, person.getFirstName());
        ps.setString(3, person.getSurName());
        ps.setString(4, person.getDni());
        ps.setBoolean(5, person.isGender());
        ps.setDate(6, new java.sql.Date(person.getBirthDate().getTime()));
        ps.setTimestamp(7, new java.sql.Timestamp(person.getCreatedAt().getTime()));
        ps.setTimestamp(8, new java.sql.Timestamp(person.getUpdatedAt().getTime()));

        this.rowsQuantityAfected = ps.executeUpdate();

        this.dbc.connection.close();

        return rowsQuantityAfected;
    }
    
    public List<Person> getAll() throws SQLException {
        this.dbc = new DataBaseContext();

        this.listPerson = new ArrayList<>();

        this.script = "select * from tperson";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);

        ResultSet rows = ps.executeQuery();

        while (rows.next()) {
            Person personTemp = new Person();

            personTemp.setIdPerson(rows.getString("idPerson"));
            personTemp.setFirstName(rows.getString("firstName"));
            personTemp.setSurName(rows.getString("surName"));
            personTemp.setDni(rows.getString("dni"));
            personTemp.setGender(rows.getBoolean("gender"));
            personTemp.setBirthDate(rows.getDate("birthDate"));
            personTemp.setCreatedAt(rows.getTimestamp("createdAt"));
            personTemp.setUpdatedAt(rows.getTimestamp("updatedAt"));

            this.listPerson.add(personTemp);
        }

        this.dbc.connection.close();

        return this.listPerson;
    }
}
