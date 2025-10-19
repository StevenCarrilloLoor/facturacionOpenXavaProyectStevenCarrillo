package com.tuempresa.facturacion.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Producto {
    
    @Id
    @Column(length=9)
    int numero;
    
    @Column(length=50)
    @Required
    String descripcion;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @DescriptionsList
    private Categoria categoria;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;
    
    @Required
    @Stereotype("MONEY")
    private BigDecimal precio;
}