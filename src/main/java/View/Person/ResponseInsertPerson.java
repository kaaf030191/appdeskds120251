/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class ResponseInsertPerson {

    private String type;
    private List<String> listMesagge;

    public ResponseInsertPerson() {
        this.type = "error";
        this.listMesagge = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setSuccess() {
        this.type = "success";
    }

    public void setWarning() {
        this.type = "warning";
    }

    public void setError() {
        this.type = "error";
    }

    public void setException() {
        this.type = "exception";
    }

    public List<String> getListMesagge() {
        return listMesagge;
    }

    public void addMessage(String message) {
        this.listMesagge.add(message);
    }
    
    public void setMessageException() {
        this.listMesagge = List.of("Algo salió mal, estamos trabajando para solucionarlo.");
    }

}
