package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el servicio para la gestión de tareas.
 * Se encarga de coordinar la creación, finalización y consulta de tareas
 * y de gestionar el envío de alertas por correo electrónico.
 */
public class Servicio {
	private MailerStub mailer;
	private DBStub db;
	
	/**
     * Constructor del servicio que inicializa el correo y base de datos.
     * @param mailer envío de correos.
     * @param db repositorio de datos.
     */
    public Servicio(MailerStub mailer, DBStub db) {
    	this.mailer = mailer;
        this.db = db;
		// TODO Auto-generated constructor stub
	}

    /**
     * Crea una tarea, la almacena y revisa si hay alertas pendientes de enviar.
     * @param nombre El nombre de la tarea.
     * @param fechaLimite La fecha límite para completar la tarea.
     */
	public void crearTarea(String nombre, LocalDate fechaLimite) {
		ToDo nuevaTarea = new ToDo(nombre, "", fechaLimite, false);
        
        db.getTareas().add(nuevaTarea);
        revisarYEnviarAlertas();
    }
    
	/**
     * Registra un correo electrónico en la base de datos para recibir alertas.
     * @param email  dirección de correo.
     */
    public void agregarEmail(String email) {
        db.getEmails().add(email);
        revisarYEnviarAlertas();
    }
    
    /**
     * Busca una tarea por su nombre y la marca como completada.
     * @param nombre El nombre de la tarea
     */
    public void marcarComoFinalizada(String nombre) {
        for (ToDo tarea : db.getTareas()) {
            if (tarea.getNombre().equals(nombre)) {
                tarea.setCompletado(true);
                break; 
            }
        }
        
        
        revisarYEnviarAlertas();  
    }
    
    /**
     * Recupera una lista con todas las tareas que aún no han terminado.
     * @return Una lista de objetos ToDo pendientes.
     */
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
    
    /**
     * Comprueba si existen tareas caducadas y envía notificaciones a todos los emails registrados.
     */
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
