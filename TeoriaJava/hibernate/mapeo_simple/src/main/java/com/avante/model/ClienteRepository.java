/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jprof
 */
public class ClienteRepository {
    private static final Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
    
    public void insert(Cliente cliente) {
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            Transaction tx = sess.beginTransaction();
            
            try {
               sess.persist(cliente);
               tx.commit();
            }
            catch(Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                
                throw e;
            }
        }
        catch (Exception e) {
            logger.error("Error al insertar un cliente");
            throw e;
        }
    }
    
    public Cliente retrieve(int id) {
        Cliente cliente = null;
        
         try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            cliente = sess.get(Cliente.class,id);
        }
        catch (Exception e) {
            logger.error("Error al recuperar un cliente");
            throw e;
        }
         
        return cliente;
    }
    
    public void update(Cliente cliente) {
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            Transaction tx = sess.beginTransaction();
            
            try {
               sess.merge(cliente);
               tx.commit();
            }
            catch(Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                
                throw e;
            }
        }
        catch (Exception e) {
            logger.error("Error al actualizar un cliente");
            throw e;
        }
    }
    
    public void remove(Cliente cliente) {
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            Transaction tx = sess.beginTransaction();
            
            try {
               sess.remove(cliente);
               tx.commit();
            }
            catch(Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                
                throw e;
            }
        }
        catch (Exception e) {
            logger.error("Error al actualizar un cliente");
            throw e;
        }
    }
    
    public List<Cliente> listAll () {
        List<Cliente> lista = new ArrayList<>();
        
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            lista = sess.createQuery("from Cliente", Cliente.class).list();
    //         lista = sess.createNativeQuery("select * from cliente",Cliente.class).list();
        }
        catch(Exception e) {
            logger.error("Error al listar todos los clientes");
            throw e;
        }
        
        return lista;
    }
    
    public List<Cliente> searchByEmail (String email) {
        List<Cliente> lista = new ArrayList<>();
        
        
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            lista = sess.createQuery("from Cliente c where c.email=:e", Cliente.class)
                    .setParameter("e", email)
                    .list();
    
    //      lista = sess.createNativeQuery("select * from cliente where email=?",Cliente.class).list();
        }
        catch(Exception e) {
            logger.error("Error al listar todos los clientes");
            throw e;
        }
        
        return lista;
    }
}
