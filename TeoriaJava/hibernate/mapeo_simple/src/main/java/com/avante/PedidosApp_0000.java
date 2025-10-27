/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante;

import com.avante.model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jprof
 */
public class PedidosApp_0000 {
    // Obtengo la utilidad de logging
    private static final Logger logger = LoggerFactory.getLogger(PedidosApp_0000.class);
  

    public static void main(String[] args) {
        // Cliente que se va insertar
        Cliente cliente = Cliente.builder()
                .nombre("Juan Manuel")
                .email("jmpinero@avante.es")
                .telefono("7777777777")
                .build();
        
        
        // Declaro mi transaccion
        Transaction tx = null;
        
        try (
                SessionFactory factory = new Configuration().configure().buildSessionFactory();
                Session sess = factory.openSession();
                
        ) {

            // Iniciamos una transaccion
            tx = sess.beginTransaction();

            // Operamos
            try {
                sess.persist(cliente);
                
                logger.info(String.format("El id del cliente es %d.\n",cliente.getId()));
                
                
                
                // Hacemos commit de la transaccion
                tx.commit();
            }
            catch(Exception e) {
                if (tx!=null && tx.isActive()) {
                   tx.rollback();
                }
                
                throw e;
            }
        }
        catch(Exception e) {
            logger.error("Fallo insertando cliente 4444");
            throw e;
        }
    }
}
