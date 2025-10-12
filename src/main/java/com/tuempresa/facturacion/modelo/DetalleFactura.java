package com.tuempresa.facturacion.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class DetalleFactura {
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @ReferenceView("Simple")
    private Producto producto;
    
    @Required
    private int cantidad;
    
    @Stereotype("MONEY")
    private BigDecimal precioUnitario;
}