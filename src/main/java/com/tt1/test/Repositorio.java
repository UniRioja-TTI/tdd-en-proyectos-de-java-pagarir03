package com.tt1.test;

/**
 * Clase  encargada de la persistencia de los objetos ToDo.
 * Su función es gestionar el acceso a la base de datos o sistema de almacenamiento.
 */
public class Repositorio {
	
	/**
     * Busca una tarea en el sistema de almacenamiento por su nombre.
     * @param nombre nombre de la tarea.
     * @return El objeto ToDo encontrado.
     * @throws UnsupportedOperationException.
     */
	public ToDo buscarTarea(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    
	/**
     * Actualiza la información de la tarea en el repositorio.
     * @param tarea El objeto ToDo con los datos actualizados.
     * @throws UnsupportedOperationException
     */
    public void actualizarTarea(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada."); 
    }
}

