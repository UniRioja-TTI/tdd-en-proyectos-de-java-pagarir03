package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTest {
	private com.tt1.test.Servicio servicio;
	private MailerStub mailer;
	private DBStub db;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	   
	}

	@BeforeEach
	void setUp() throws Exception {
		// ARRANGE
	    mailer = new MailerStub(); 
	    db = new DBStub();
	    servicio = new Servicio(mailer, db);
	}

	@AfterEach
	void tearDown() throws Exception {
		 mailer = null;
		 db = null;
		 servicio = null;
	}
	

	@Test
	void testCrearTarea() {
		
		    // 1. ARRANGE (Organizar): 
		    String nombre = "Comprar pan";
		    LocalDate fecha = LocalDate.now().plusDays(1);

		    // 2. ACT (Actuar): 
		    servicio.crearTarea(nombre, fecha);

		    // 3. ASSERT (Afirmar): 
		    
		    assertNotNull(servicio.consultarPendientes());
		}
	

	@Test
	void testAgregarEmail() {
		// Arrange
	    String email = "pagarir@unirioja.es";

	    // Act
	    servicio.agregarEmail(email);

	    // Assert
	    assertDoesNotThrow(() -> servicio.agregarEmail(email));
	}

	@Test
	void testMarcarComoFinalizada() {
		// Arrange
	    servicio.crearTarea("Tarea 1", LocalDate.now().plusDays(1));

	    // Act
	    servicio.marcarComoFinalizada("Tarea 1");

	    // Assert
	    assertTrue(servicio.consultarPendientes().isEmpty()); 
	}

	@Test
	void testConsultarPendientes() {
		
		// Arrange
	    servicio.crearTarea("Pendiente", LocalDate.now().plusDays(1));
	    servicio.crearTarea("Finalizada", LocalDate.now().plusDays(1));
	    servicio.marcarComoFinalizada("Finalizada");

	    // Act
	    List<ToDo> pendientes = servicio.consultarPendientes();

	    // Assert
	    assertEquals(1, pendientes.size()); 
	    assertEquals("Pendiente", pendientes.get(0).getNombre());
	}
	
}
