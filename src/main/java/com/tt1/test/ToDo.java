package com.tt1.test;
import java.time.LocalDate;

/**
 * Representa una tarea dentro del sistema de gestión.
 * Contiene la información básica como nombre, descripción y estado de cumplimiento. 
 */

public class ToDo {
	
	
	private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /**
     * Constructor principal para crear una instancia de una tarea. 
     * @param nombre Identificador. 
     * @param descripcion Descripción de lo que se debe realizar. 
     * @param fechaLimite Fecha límite para hacer la tarea. 
     * @param completado Estado de la tarea. 
     */
    public ToDo(String nombre, String descripcion, LocalDate fechaLimite, boolean completado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = completado;
    }
    /**
     * Devuelve el nombre de la tarea. 
     * @return El nombre actual. 
     */
    public String getNombre() { return nombre; }
    /**
     * Modifica el nombre de la tarea. 
     * @param nombre  nuevo nombre a asignar. 
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    /**
     * Devuelve la descripción detallada. 
     * @return  descripción actual. 
     */
    public String getDescripcion() { return descripcion; }
    
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    /**
     * Devuelve la fecha límite de entrega. 
     * @return  LocalDate con la fecha. 
     */
    public LocalDate getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    /**
     * Indica si la tarea ha sido finalizada. 
     * @return true si está completada, false en caso contrario. 
     */
    public boolean isCompletado() { return completado; }
    /**
     * Cambia el estado de finalización de la tarea. 
     * @param completado  estado de la tarea. 
     */
    public void setCompletado(boolean completado) { this.completado = completado; }

}
