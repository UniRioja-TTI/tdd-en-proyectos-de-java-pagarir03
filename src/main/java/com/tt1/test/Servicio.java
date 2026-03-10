package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class Servicio {
    public Servicio(MailerStub mailer, DBStub db) {
		// TODO Auto-generated constructor stub
	}

	public void crearTarea(String nombre, LocalDate fechaLimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    
    public void agregarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
    
    public void marcarComoFinalizada(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
    
    public List<ToDo> consultarPendientes() {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
}
