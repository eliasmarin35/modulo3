/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante;

import com.avante.model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author jprof
 */
public class PedidosApp {

    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session sess = factory.openSession();
        
        // Iniciamos una transaccion
        Transaction tx = sess.beginTransaction();
        
        // Operamos
        Cliente cliente = Cliente.builder()
                .nombre("Juan Manuel")
                .email("jmpinero@avante.es")
                .telefono(null)
                .build();
        
        sess.persist(cliente);
        
        // Hacemos commit de la transaccion
        tx.commit();
    }
}
