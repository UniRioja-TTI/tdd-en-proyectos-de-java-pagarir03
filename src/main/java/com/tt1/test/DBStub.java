package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    public void guardarTarea(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
    
    public List<ToDo> obtenerTodas() {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
    
    public void guardarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
	
}
