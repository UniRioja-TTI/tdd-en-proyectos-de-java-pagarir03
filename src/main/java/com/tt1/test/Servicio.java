package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Servicio {
	private MailerStub mailer;
	private DBStub db;
	
    public Servicio(MailerStub mailer, DBStub db) {
    	this.mailer = mailer;
        this.db = db;
		// TODO Auto-generated constructor stub
	}

	public void crearTarea(String nombre, LocalDate fechaLimite) {
		ToDo nuevaTarea = new ToDo(nombre, "", fechaLimite, false);
        
        db.getTareas().add(nuevaTarea);
        revisarYEnviarAlertas();
    }
    
    public void agregarEmail(String email) {
        db.getEmails().add(email);
        revisarYEnviarAlertas();
    }
    
    public void marcarComoFinalizada(String nombre) {
        for (ToDo tarea : db.getTareas()) {
            if (tarea.getNombre().equals(nombre)) {
                tarea.setCompletado(true);
                break; 
            }
        }
        
        
        revisarYEnviarAlertas();  
    }
    
    public List<ToDo> consultarPendientes() {
    	List<ToDo> pendientes = new ArrayList<>();
        for (ToDo tarea : db.getTareas()) {
            if (!tarea.isCompletado()) {
                pendientes.add(tarea);
            }
        }
        
        revisarYEnviarAlertas();
        return pendientes;
    }
    
    private void revisarYEnviarAlertas() {
        
        LocalDate hoy = LocalDate.now();
        for (ToDo tarea : db.getTareas()) {
           if (!tarea.isCompletado() && tarea.getFechaLimite().isBefore(hoy)) {
                for (String email : db.getEmails()) {
                    mailer.enviarCorreo(email, "Alerta: La tarea '" + tarea.getNombre() + "' ha caducado.");
                }
            }
        }
    }
}
