/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Person.Person;
import Model.Phone.Phone;
import Model.Provider.Provider;
import Model.Provider.ProviderDao;
import View.Person.RequestInsertPerson;
import View.Person.ResponseInsertPerson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author KAAF0
 */
public class PersonController {

    private final ProviderDao providerDao = new ProviderDao();

    public List<Provider> actionGetAllProvider() {
        List<Provider> listProvider = new ArrayList<>();

        try {
            listProvider = providerDao.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listProvider;
    }

    public ResponseInsertPerson actionInsert(RequestInsertPerson requestInsertPerson) {
        try {
            Person person = new Person();

            person.setIdPerson(UUID.randomUUID().toString());
            person.setFirstName(requestInsertPerson.firstName);
            person.setSurName(requestInsertPerson.surName);
            person.setDni(requestInsertPerson.dni);
            person.setGender(requestInsertPerson.gender);
            person.setBirthDate(requestInsertPerson.birtDate);
            person.setCreatedAt(new Date());
            person.setUpdatedAt(person.getCreatedAt());
            
            //Insertar la persona enviando los datos a la capa del modelo

            for (Map item : requestInsertPerson.listPhone) {
                Phone phone = new Phone();

                phone.setIdPhone(UUID.randomUUID().toString());
                phone.setIdPerson(person.getIdPerson());
                phone.setIdProvider(providerDao.getByName(item.get("provider").toString()).getIdProvider());
                phone.setNumber(item.get("number").toString());
                phone.setCreatedAt(person.getCreatedAt());
                phone.setUpdatedAt(person.getCreatedAt());
                
                //Insertar el teléfono enviando los datos a la capa del modelo
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
