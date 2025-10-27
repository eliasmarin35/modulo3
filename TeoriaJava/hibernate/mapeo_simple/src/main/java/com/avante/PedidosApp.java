/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante;

import com.avante.model.Cliente;
import com.avante.model.ClienteRepository;
import com.avante.model.HibernateUtil;
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
public class PedidosApp {
    // Obtengo la utilidad de logging
    private static final Logger logger = LoggerFactory.getLogger(PedidosApp.class);
  

    public static void main(String[] args) {
        // Cliente que se va insertar
        Cliente cliente = Cliente.builder()
                .nombre("Federico")
                .email("fede@hotmail.com")
                .telefono("231234567")
                .build();
        
        ClienteRepository repo = new ClienteRepository();
        repo.insert(cliente);
        
        // Se cierra la factoria de sesiones
        HibernateUtil.getInstance().shutdown();
    }
}
