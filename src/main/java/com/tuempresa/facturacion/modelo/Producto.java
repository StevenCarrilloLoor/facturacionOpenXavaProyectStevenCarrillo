package com.tuempresa.facturacion.modelo;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple",
    members="numero, descripcion"
)
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
    @DecimalMin(value="0.01", message="El precio debe ser mayor que cero")
    private BigDecimal precio;
}