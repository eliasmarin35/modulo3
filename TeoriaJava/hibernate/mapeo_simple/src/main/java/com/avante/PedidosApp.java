/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante;

import com.avante.model.Cliente;
import com.avante.model.ClienteRepository;
import com.avante.model.HibernateUtil;
import com.avante.model.Pedido;
import java.time.LocalDate;
import java.time.Month;
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
        ClienteRepository repo = new ClienteRepository();
        
        Cliente c = Cliente.builder()
                .nombre("Luis")
                .email("luis@gmail.com")
                .build();
        
        Pedido p = Pedido.builder()
                .fecha_pedido(LocalDate.of(2025, Month.MARCH, 20))
                .cliente(c)
                .build();
        
     //   c.getPedidos().add(p);
        
        repo.insert(c);
 
        HibernateUtil.getInstance().shutdown();
    }
}
