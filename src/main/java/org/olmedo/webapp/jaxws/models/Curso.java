package org.olmedo.webapp.jaxws.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement //solamente para XML para que se pueda convertir
@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

   // @XmlTransient // con esto el instructor no se envia en el xml se genera el xml pero sin el instructor
   // @JsonbTransient  //para no incluir en el json el instrusctor
    //@JsonIgnore // es lo mismo que @jsonbTransient pero usando la dependencia de resteasy-jackson2 provided esta es mas
    //robusta
    @JsonIgnoreProperties({"cursos", "handler", "hibernateLazyInitializer"}) // para que no muestre los json curso instructor que estan anidados json curso con esto detenemos la jerarquia recursiva
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

    private Double duracion;

    public Curso() {

    }

    public Curso(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
