package com.tuempresa.facturacion.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members=
    "anio, numero, fecha;" +
    "cliente;" +
    "detalles;" +
    "observaciones"
)
public class Factura {
    
    @Id
    @Hidden
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
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
    
    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad, precioUnitario")
    private Collection<DetalleFactura> detalles = new ArrayList<>();
    
    @Column(length=500)
    @Stereotype("MEMO")
    private String observaciones;
}