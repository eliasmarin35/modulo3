/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.usersrest.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Vamos a cambiar el comportamiento del método save del JPARepository para el
 * repositorio de usuarios. Esto es necesario para que el valor de
 * creationTimestamp se actualize al insertar un User en la base de datos.
 * 
 * creationTimestamp en la base de datos tiene una restricción DEFAULT y por
 * tanto lo hemos excluido del insert si es null. Pero entonces al insertar nos
 * quedamos con un objeto que no sabe que válor tiene currentTimestamp (lo ha
 * asignado postgresql automáticamente como hace con los ids). La solución es
 * hacer un refresh después de save, para asegurarse que los datos del objeto
 * Java se actualizan con los valores que hay en la base de datos.
 *
 * 
 * Para que esta clase se mezcle con el resto del repositorio que genera
 * sprinboot automáticamente tenemos que tener una interfaz que defina este
 * método (save) y despues hacer que la interfaz del repositorio herede de
 * JPARepository y de nuestra propia interfaz. Sprinboot entendera que nuestra
 * interfaz ya tiene una implementación (la de este archivo) y la mezclará con
 * el código que genere a partir de la interfaz JPARepository.
 * 
 * 
 * Para que springboot indetifique esta clase como la implementación que hay
 * que usar, el nombre de la clase debe de ser el mismo del de la interfaz
 * acabado en "Impl" (de Implementation, implementación).
 * 
 * Como la interfaz se llama RepositorySaveAndRefresh, esta clase se llamará
 * RepositorySaveAndRefreshImpl
 *
 * @author jprof
 */
public class RepositorySaveAndRefreshImpl<T> implements RepositorySaveAndRefresh<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public T save(T entity) {
        if (!entityManager.contains(entity)) {
            entityManager.persist(entity);
        }
        entityManager.flush();
        entityManager.refresh(entity);
        return entity;
    }
}
