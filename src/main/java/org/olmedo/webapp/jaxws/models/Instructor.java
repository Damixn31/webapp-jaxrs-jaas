package org.olmedo.webapp.jaxws.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructores")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // "handler" "hibernateLazyInitializer" --> para borrar esos atributos si queda en el cache como basura lo ignoramos del json
    @JsonIgnoreProperties({"instructor", "handler", "hibernateLazyInitializer"}) // es bueno tenerlo en ambos lados aca y en la clase curso Curso para la inversa
    // un instructor puede tener muchos cursos
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL) //para restablecer la relacion inversa con el atrubuto de la contraparte -> "instructor viene de la clase Curso
    private List<Curso> cursos;

    private String nombre;
    private String apellido;

    public Instructor() {
        this.cursos = new ArrayList<>();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
