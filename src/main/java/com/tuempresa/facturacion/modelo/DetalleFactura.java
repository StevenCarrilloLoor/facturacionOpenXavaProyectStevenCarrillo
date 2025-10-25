package com.tuempresa.facturacion.modelo;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class DetalleFactura {
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @ReferenceView("Simple")
    private Producto producto;
    
    @Required
    @Min(value=1, message="La cantidad debe ser al menos 1")
    private int cantidad;
    
    @DefaultValueCalculator(
        value=com.tuempresa.facturacion.calculadores.CalculadorPrecioPorUnidad.class,
        properties=@PropertyValue(
            name="numeroProducto",
            from="producto.numero")
    )
    @Money
    @Min(value=0, message="El precio debe ser mayor o igual a cero")
    BigDecimal precioPorUnidad;
    
    @Money
    @Depends("precioPorUnidad, cantidad")
    public BigDecimal getImporte() {
        if (precioPorUnidad == null) return BigDecimal.ZERO;
        return new BigDecimal(cantidad).multiply(precioPorUnidad);
    }
}