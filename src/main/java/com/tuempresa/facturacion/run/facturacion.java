package com.tuempresa.facturacion.run;

import org.openxava.util.*;

public class facturacion {
	public static void main(String[] args) throws Exception {
		// DBServer.start("facturacion-db");
		AppServer.run("facturacion");
	}
}