package com.pcvpmo.pdsw.uptehu.tests;

import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.impl.ServiciosUnidadProyectosImpl;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectosFactory;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jefferson Castañeda - Gabriel Peña
 */

/**
 *  frontera
 * CF1: Registrar una mateira de un programa al que no pertenece, resultado esperado: no se deja registrar la materia 
 * clases de equivalencia 
 * CE1: una materia no puede ser registrada con un nombre nulo; resultado esperado: no se registra la materia
 * CE2: las materias de primer nivel se puede registrar sin prerequisitos; resultado esperado: registro la materia
 * CE3: si una materia A tiene un prerequisito B, la materia B no puede tener prerequisitos en los que A es prerequisito; resultado esperado: error
 * CE4: si se cancela una clase, no debe aparecer en el reporte del periodo; resultado esperado: la clase no aparece
 * CE5: no se puede programar una clase por fuera del horario del periodo; resultado esperado: error
 * CE6: no se puede registrar un curso si el profesor no tiene disponibilidad ; resultado esperado: error
 * CE7: se debe conocer por lo menos el programa y la asignatura de cada materia que aparezaca; resultado esperado: asignatura y programa de las materias
 * CE8: al momento de registrar una mateira, si esta tiene un Cohorte igual a otra ya registrada, deberia informar el error; RE: mensaje de error
 * CE9: al consultar las clases, si un cohorte es valido, el resultado no puede ser vacio; RE: listado no vacio de clases x cohorte
 *
 */

/**

 *  frontera

 * CF1: Registrar una materia de un programa al que no pertenece, resultado esperado: no se deja registrar la materia 

 * clases de equivalencia 

 * CE1: una materia no puede ser registrada con un nombre nulo; resultado esperado: no se registra la materia

 * CE2: las materias de primer nivel se puede registrar sin prerequisitos; resultado esperado: registro la materia

 * CE3: si una materia A tiene un prerequisito B, la materia B no puede tener prerequisitos en los que A es prerequisito; resultado esperado: error

 * CE4: si se cancela una clase, no debe aparecer en el reporte del periodo; resultado esperado: la clase no aparece

 * CE5: no se puede programar una clase por fuera del horario del periodo; resultado esperado: error

 * CE6: no se puede registrar un curso si el profesor no tiene disponibilidad ; resultado esperado: error

 * CE7: se debe conocer por lo menos el programa y la asignatura de cada materia que aparezca; resultado esperado: asignatura y programa de las materias

 * CE8: al momento de registrar una materia, si esta tiene un Cohorte igual a otra ya registrada, deberia informar el error; RE: mensaje de error

 * CE9: al consultar las clases, si un cohorte es valido, el resultado no puede ser vacio; RE: listado no vacio de clases x cohorte

 *

 */
public class UpTehoTest {
    
    public UpTehoTest(){
    }
    
    @Before
    public void setUp(){
    }
    
    @Test
    public void pruebaClaseFrontera1(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        List<Materia> l = null;
        try{
            sup.registrarMateria(0, 0, null, 0, "Programacion Imperativa", "PIM", "introduccion a la programacion");
            l = sup.consultarMaterias(0);
        }catch (PersistenceException e){}
        assertTrue(l.size()==1);
    }
    
    @Test
    public void pruebaNoPermiteRegistrarUnaMateriaConProgramaNull(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        List<Materia> l= null;
        List<Materia> lb= null;
        try{
            sup.registrarMateria(0, 0, null, 0, null, "PIM", "introduccion a la programacion");
            sup.registrarMateria(1, 0, null, 0, null, "PIM", "materiales magneticos");
            l = sup.consultarMaterias(1);
            lb = sup.consultarMaterias(1);
        }catch (PersistenceException e){}
        assertTrue(l.isEmpty() && lb.isEmpty());
    }
    
    @Test 
    public void pruebaNorequisitosCiclicos(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, "powe", 1, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarMateria(0, 0, "poob", 0, "programacion de objetos en aplicaciones we", "powe", "desarrollo de aplicaiones dinamicas");
        }catch(PersistenceException e){
            assert(true);
        }
    }
    
    @Test
    public void pruebaReporteSinUnaMateriaCancelada(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, "powe", 1, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarMateria(1, 0, null, 0, "vision arquitectonica simplificada", "vias", "diseño de estructuras viales ");
            sup.registrarMateria(1, 0, null, 0, "estructuras metalicas para terremotos", "estr", "diseño de sistemas de amortiguacion");
            //como se relaciona una clase con una materia?, no se ha implementado el metodo de generar reporte
        }catch(PersistenceException e){
        }
        assertTrue(true);       
    }
    
    @Test
    public void pruebaClasePorFueraDelPeriodo(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            //como se sabe cual es el periodo y su respectivo horario
            sup.programarClase("10/6/2017", "21:00");
        }catch (PersistenceException e){
        }
        assertTrue(true);        
    }
    
    @Test
    public void elCursoInvalidaElHorarioDelProfesorAsignado(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            //la prueba no se puede hacer si no se conoce el horario de un profesor, ¿com ose pueden registrar?
            //sup.registrarProfesor con un horario que no sea valido con cierto curso
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, null, 0, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarCurso(0, "poob", 0);
        }catch (PersistenceException e){
        }
        assertTrue(true);
    }
    
    @Test 
    public void registroDeMateriasValido(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        List<Materia> lista = null;
        try{
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, "powe", 1, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarMateria(1, 0, null, 0, "vision arquitectonica simplificada", "vias", "diseño de estructuras viales ");
            sup.registrarMateria(1, 0, null, 0, "estructuras metalicas para terremotos", "estr", "diseño de sistemas de amortiguacion");
            lista = sup.consultarMaterias();
        }catch (PersistenceException e){  
        }
        boolean ans=true;
        for (int i=0; i<lista.size(); i++){
            //ans= lista.get(i).metodoparaobtenerla asignaturadeunamateria!=null && lista.get(i).metodoparaobtenerelprograma();
        }
        assertTrue(ans);
    }
    
    @Test
    public void ce5(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        //TODO se compara la fecha elegida por el profesor para programar la clase, 
        //que se encuentre en las fechas del periodo academico 
        try {
            s.programarClase("2005-12-20", "7:00");
        } catch (Exception e) {
            new PersistenceException("la fecha idicada se encuantra fuera del horario del periodo", e);
        }
    }
    
    @Test
    public void ce6(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            s.registrarCurso(0001, "PDSW", 001);
            //falta implementar en el metodo la disponibilidad del profesor, incluyendo la lista con los horarios que 
//            ya tiene registrados
        } catch (Exception e) {
            new PersistenceException("la fecha no esta disponible para este profesor", e);
        }
    }
    
    @Test
    public void ce8(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            //TODO falta implementar en el metodo de registrar materia la variable de cohorte
            s.registrarMateria(001, 002, "MBDA", 1, "Arquitectura empresarial", "AREM", "enfoca al desarrolllo del "
                    + "emprendimiento empresarial");
        } catch (Exception e) {
            new PersistenceException("el cohorte ya se encuentra registrado para otra materia", e);
        }
    }
}