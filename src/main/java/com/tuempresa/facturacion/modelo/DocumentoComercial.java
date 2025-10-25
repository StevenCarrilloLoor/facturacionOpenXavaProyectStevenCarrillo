package com.tuempresa.facturacion.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members=
    "anio, numero, fecha;" +
    "datos {" +
    "cliente;" +
    "observaciones" +
    "}"
)
public abstract class DocumentoComercial extends Identificable {
    
    @Column(length=4)
    @Required
    private int anio;
    
    @Column(length=6)
    @Required
    private int numero;
    
    @Required
    private LocalDate fecha;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @ReferenceView("Simple")
    private Cliente cliente;
    
    @Column(length=500)
    @Stereotype("MEMO")
    private String observaciones;
}