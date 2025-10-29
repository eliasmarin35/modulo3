
package modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CursosRepository {
    private static final Logger logger = LoggerFactory.getLogger(CursosRepository.class);
    
    public void insert(Curso curso){
        try(
                Session sess = HibernateUtil.getInstance().openSession();
                
        ){
            Transaction tx = sess.beginTransaction();
            
            try{
                sess.persist(curso);
                tx.commit();
            }
            catch(Exception e){
                if (tx != null && tx.isActive() ) {
                    tx.rollback();
                }
                throw e;
            }
        }
        catch(Exception e){
            logger.error("Error al insertar curso.");
            throw e;
        }
    }
    public Curso retrieve(int id) {
        Curso curso = null;
        
         try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            curso = sess.get(Curso.class,id);
        }
        catch (Exception e) {
            logger.error("Error al recuperar un curso");
            throw e;
        }
         
        return curso;
    }
    
    public void update(Curso curso) {
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            Transaction tx = sess.beginTransaction();
            
            try {
               sess.merge(curso);
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
            logger.error("Error al actualizar un curso");
            throw e;
        }
    }
    
    public void remove(Curso curso) {
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ) {
            Transaction tx = sess.beginTransaction();
            
            try {
               sess.remove(curso);
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
            logger.error("Error al intentar borrar un curso");
            throw e;
        }
    }
    
    public List<Curso> listAll(){
        List<Curso> lista = new ArrayList<>();
        
        try(
                Session sess = HibernateUtil.getInstance().openSession();
                
        ){
            //CONSULTA CON HQL independiente de si usas postgre o no, MEJOR!
            lista = sess.createQuery("From Curso", Curso.class).list();
            //CONSULTA EN SQL DE POSTGRES menos recomendado!
            //lista = sess.createNativeQuery("SELECT * FROM cursos", Curso.class).list();
        }
        catch(Exception e){
            logger.error("Error al listar cursos.");
            throw e;
        }
        return lista;
    }
    //Metodo para obtener por email un Alumno PONGO CURSO MIENTRAS GENERO MAPEO
    public List<Curso> ListEmail(String s){
        List<Curso> lista = new ArrayList<>();
        
        try (
                Session sess = HibernateUtil.getInstance().openSession();
        ){
            lista = sess.createQuery("From Curso c where c.e", Curso.class).list();
        } catch (Exception e) {
            logger.error("Error al listar cursos.");
            throw e;
        }
           
        return lista;
    }
}

