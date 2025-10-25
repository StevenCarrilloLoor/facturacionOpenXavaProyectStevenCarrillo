package com.tuempresa.facturacion.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Categoria extends Identificable {
    
    @Column(length=50)
    @Required
    private String descripcion;
}