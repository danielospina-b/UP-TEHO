package com.pcvpmo.pdsw.upteho.managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed Bean encargado de la comunicación entre capa logica y presentacion
 * @author Daniel Ospina
 */
@ManagedBean(name = "UnidadProyectos")
@SessionScoped
public class UnidadProyectosBean implements Serializable{
    
    public UnidadProyectosBean() {
    }
    
    /**
     * Registra una Materia nueva con los datos necesarios respectivos
     * @param idPrograma id del programa de grado al que pertenece la materia
     * @param idAsignatura id de la asignatura
     * @param siglaRequisito sigla de la materia requisito
     * @param tipoRequisito tipo de requisito (0 = prerequisito, 1 = corequisito)
     * @param nombreMateria Nombre completo de la materia
     * @param siglaMateria Sigla de la materia a registrar
     * @param descripcionMateria descripcion de la materia
     */
    public void registrarMateria(int idPrograma, int idAsignatura, String siglaRequisito, int tipoRequisito, String nombreMateria, String siglaMateria, String descripcionMateria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Cancela una clase de un Curso especifico
     * @param cohorte Codigo cohorte del curso
     * @param idClase id de la clase a cancelar
     */
    public void cancelarClase(int cohorte, int idClase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void programarClase(String fecha, String hora) {
        //TODO comprobar que tipo es la fecha y hora, salones y recursos
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Registra un nuevo curso
     * @param idAsignatura id de la asignatura
     * @param siglaMateria sigla de la materia a la cual pertenece el grupo
     * @param idProfesor id del profesor que dictara el curso
     */
    public void registrarCurso(int idAsignatura, String siglaMateria, int idProfesor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las materias registradas en el sistema
     * @return una lista de Materia
     */
    public List<Materia> consultarMaterias() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las materias de una asignatura
     * @return una lista con las Materias
     */
     public List<Materia> consultarMaterias(int idAsignatura){
         throw new UnsupportedOperationException("Not supported yet.");
     }
    
    /**
     * Consulta la lista de programas de la Unidad de Proyectos
     * @return una lista de Programas
     */
    public List<Programa> consultarProgramas() {
        //TODO comprobar que es String para una lista desplegable
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las asignaturas (de un programa especifico)
     * @return Lista de Asignaturas
     */
    public List<Asignatura> consultarAsignaturas() {
        //TODO confirmar si se puede de un programa especifico (segun lo seleccionado en la lista desplegable de programa)
        //TODO comprobar que es String para una lista desplegable
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
 
    
    /**
     * Consulta los periodos academicos
     * @return una lista de Periodos academicos
     */
    public List<Periodo> consultarPeriodo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los profesores filtrados segun la busqueda
     * @param busqueda cadena para filtrar por nombre de un profesor
     * @return Lista de profesores segun el filtrado por busqueda
     */
    public List<Profesor> consultarProfesores(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las clases programadas para un curso en especifico
     * @param cohorte
     * @return Lista de Clases de un curso
     */
    public List<Clase> consultarClases(String cohorte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los recursos disponibles que pueden ser asignados a una clase
     * @return Lista de recursos disponibles
     */
    public List<Recurso> consultarRecursosDisponibles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los recursos asignados a una clase en particular
     * @return Lista de recursos asignados a una clase
     */
    public List<Recurso> consultarRecursosClase(String cohorte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
