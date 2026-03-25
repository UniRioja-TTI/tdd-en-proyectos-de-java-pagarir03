package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    public void guardarTarea(ToDo tarea) {
        this.tareas.add(tarea); 
    }

    public List<ToDo> obtenerTodas() {
        return this.tareas; 
    }

    public void guardarEmail(String email) {
        this.emails.add(email);
    }
    
    public List<String> getEmails() {
        return this.emails;
    }

    public List<ToDo> getTareas() {
        return this.tareas;
    }

}
