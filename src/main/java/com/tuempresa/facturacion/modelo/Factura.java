package com.tuempresa.facturacion.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity 
@Getter @Setter
@View(extendsView="super.DEFAULT",
    members=
    "datos {" +
    "detalles" +
    "};" +
    "pedidos { pedidos }"
)
@View(name="SinClienteNiPedidos",
    members=
    "anio, numero, fecha;" +
    "detalles;" +
    "observaciones"
)
public class Factura extends DocumentoComercial {
    
    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad, precioPorUnidad, importe")
    private Collection<DetalleFactura> detalles = new ArrayList<>();
    
    @OneToMany(mappedBy="factura")
    @CollectionView("SinClienteNiFactura")
    Collection<Pedido> pedidos;
    
    @AssertTrue(message="La factura debe tener al menos un detalle")
    private boolean isConDetalles() {
        return detalles != null && !detalles.isEmpty();
    }
}