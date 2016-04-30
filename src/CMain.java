import java.util.Scanner;
import java.io.*;

public class CMain {
	// Rellenar con los datos de los dos alumnos que presentan la práctica
	static String NombreAlumno1="Jose Manuel";
	static String ApellidosAlumno1="Rivas Medina";
	static String NIAAlumno1="1336870"; // NIA alumno1
	static String NombreAlumno2="Joan Marc";
	static String ApellidosAlumno2="Fisa Gol";
	static String NIAAlumno2="1333879"; // NIA alumno2

	static String[] NIAS={
		"0000000",
		"1331751", "1338489", "1333871", "1334772", "1248785", "1333489", "1362625", "1362820", "1335518", "1361166",
		"1359908", "1198978", "1331045", "1330932", "1315268", "1361018", "1331628", "1332305", "1365642", "1271642",
		"1337913", "1273981", "1332008", "1336562",	"1237256", "1280838", "1333879", "1330963", "1333875", "1264717",
		"1362087", "1304544", "1244934", "1303016", "1332967", "1332186", "1331305", "1311139", "1308445", "1333747",
		"1330159", "1305520", "1309551", "1337134", "1237037", "1307863", "1332458", "1360473", "1360296", "1330809",
		"1332699", "1271007", "1212833", "1316309", "1336382", "1315557", "1360275", "1331964", "1330001", "1161125",
		"1333697", "1224915", "1358335", "1316281", "1362219", "1308376", "1336870", "1362905", "1218902", "1339424",
		"1243505", "1315446", "1330790", "1360940", "1332693", "1278188", "1212793", "1303209", "1219398", "1305943",
		"1242277", "1308427", "1243509", "1316933", "1330633"			
	};

	static boolean NIACorrecto(String nia) {
		for (int i=0;i<NIAS.length; ++i) if (nia.equals(NIAS[i])) return true;
		return false;
	}

	public static class CSyntaxError extends Exception {
		private static final long serialVersionUID=2001L;
	    public CSyntaxError(String msg) {
	        super(msg);
	    }
	}
	static CInvoicing m_Invoicing;
	static int nLine=0;
	static void ProcesarNuevo(Scanner sl) throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Cliente")) {
			String nombre=sl.next();
			int numero= sl.nextInt();
			if (numero<1) throw new Exception("número de cliente menor que 1 " + numero);
			m_Invoicing.NewClient(new CClient(nombre,numero));
		} 
		else if (elemento.equalsIgnoreCase("Producto")) {
			String nombre=sl.next();
			int codigo= sl.nextInt();
			if (codigo<1) throw new Exception("código de producto menor que 1 " + codigo);
			m_Invoicing.NewProduct(new CProduct(nombre,codigo));
		}
		else if (elemento.equalsIgnoreCase("Factura")) {
			int numero=sl.nextInt();
			String nombreCliente= sl.next();
			if (numero<1) throw new Exception("número de factura menor que 1 " + numero);
			m_Invoicing.NewInvoice(new CInvoice(numero,m_Invoicing.FindClientByName(nombreCliente)));			
		}
		else if (elemento.equalsIgnoreCase("Linea")) {
			int numeroFactura= sl.nextInt();
			String nombreProducto= sl.next();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			m_Invoicing.AddProductoToInvoice(factura, producto);			
		}
		else throw new CSyntaxError("Nuevo ...");
	}
	static void ProcesarModificar(Scanner sl) throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Cliente")) {
			String nombreCliente=sl.next();
			CClient cliente=m_Invoicing.FindClientByName(nombreCliente);
			String campo=sl.next();
			if (campo.equalsIgnoreCase("Nombre")) {
				String nuevoNombre=sl.next();
				m_Invoicing.UpdateClient(cliente, nuevoNombre, cliente.m_Number);
			}
			else if (campo.equalsIgnoreCase("Numero")) {
				int nuevoNumero=sl.nextInt();
				m_Invoicing.UpdateClient(cliente, cliente.m_Name,nuevoNumero);				
			}
			else throw new CSyntaxError("Modificar Cliente ...");
		} 
		else if (elemento.equalsIgnoreCase("Producto")) {
			String nombreProducto=sl.next();
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			String campo=sl.next();
			if (campo.equalsIgnoreCase("Nombre")) {
				String nuevoNombre=sl.next();
				m_Invoicing.UpdateProduct(producto, nuevoNombre, producto.m_Code);
			}
			else if (campo.equalsIgnoreCase("Codigo")) {
				int nuevoCodigo=sl.nextInt();
				m_Invoicing.UpdateProduct(producto, producto.m_Name, nuevoCodigo);
			}
			else throw new CSyntaxError("Modificar Producto ...");
		}
		else if (elemento.equalsIgnoreCase("Factura")) {
			int numeroFactura=sl.nextInt();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			String campo=sl.next();
			if (campo.equalsIgnoreCase("Cliente")) {
				String nuevoCliente=sl.next();
				CClient cliente=m_Invoicing.FindClientByName(nuevoCliente);
				m_Invoicing.UpdateInvoiceHeader(factura,factura.m_Number,cliente);
			}
			else if (campo.equalsIgnoreCase("Numero")) {
				int nuevoNumero=sl.nextInt();
				m_Invoicing.UpdateInvoiceHeader(factura,nuevoNumero,factura.m_Client);
			}
			else throw new CSyntaxError("Modificar Factura ...");
		}		
	}
	static void ProcesarEliminar(Scanner sl) throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Cliente")) {
			String nombreCliente=sl.next();
			CClient cliente=m_Invoicing.FindClientByName(nombreCliente);
			m_Invoicing.DeleteClient(cliente);
		} 
		else if (elemento.equalsIgnoreCase("Producto")) {
			String nombreProducto=sl.next();
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			m_Invoicing.DeleteProduct(producto);
		}
		else if (elemento.equalsIgnoreCase("Factura")) {
			int numeroFactura=sl.nextInt();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			m_Invoicing.DeleteInvoice(factura);
		}		
		else if (elemento.equalsIgnoreCase("Linea")) {
			int numeroFactura= sl.nextInt();
			String nombreProducto= sl.next();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			m_Invoicing.DeleteProductFromInvoice(factura, producto);			
		}
		else throw new CSyntaxError("Eliminar ...");
	}
	static void ProcesarVer(Scanner sl)  throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Clientes")) {
			System.out.print(nLine + " : Salida : ");
			m_Invoicing.m_Clients.Print(System.out);
			System.out.println();
		} 
		else if (elemento.equalsIgnoreCase("Productos")) {
			System.out.print(nLine + " : Salida : ");
			m_Invoicing.m_Products.Print(System.out);
			System.out.println();
		}
		else if (elemento.equalsIgnoreCase("Facturas")) {
			System.out.print(nLine + " : Salida : ");
			m_Invoicing.m_Invoices.Print(System.out);			
			System.out.println();
		}
		else throw new CSyntaxError("Ver ...");		
	}
	public static void main(String[] args) throws Exception {
		System.out.println(NIAAlumno1);
		System.out.println(NombreAlumno1);
		System.out.println(ApellidosAlumno1);
		System.out.println(NIAAlumno2);
		System.out.println(NombreAlumno2);
		System.out.println(ApellidosAlumno2);
		
		if (!NIACorrecto(NIAAlumno1)) throw new Exception("El NIA " + NIAAlumno1 + " no es de alumno matriculado");
		if (!NIACorrecto(NIAAlumno2)) throw new Exception("El NIA " + NIAAlumno2 + " no es de alumno matriculado");

		m_Invoicing=new CInvoicing();
		if (args.length!=1) {
			System.out.println("Falta el nombre del fichero de órdendes");
			return;
		}
		String filename=args[0];
		System.out.println("Fichero de órdenes: " + filename);
		try {
			File ordenes=new File(filename);
			Scanner s;
			s = new Scanner(ordenes);
			while (s.hasNextLine()) {
				try {
					++nLine;
					String linea = s.nextLine();
					System.out.println(nLine + " : Linea : " + linea);
					Scanner sl = new Scanner(linea);
					//sl.useDelimiter("\\s*");
					try {
						String orden=sl.next();
						if (orden.equalsIgnoreCase("Nuevo")) ProcesarNuevo(sl);
						else if (orden.equalsIgnoreCase("Nueva")) ProcesarNuevo(sl);
						else if (orden.equalsIgnoreCase("Modificar")) ProcesarModificar(sl);
						else if (orden.equalsIgnoreCase("Eliminar")) ProcesarEliminar(sl);
						else if (orden.equalsIgnoreCase("Ver")) ProcesarVer(sl);
						else {
							sl.close();
							throw new CSyntaxError("Orden no reconocida " + linea);
						}
					}
					catch (java.util.NoSuchElementException e) {
						throw new CSyntaxError("Error de sintaxis: " + linea);
					}
				}
				catch (Exception e) {
					System.out.println(nLine + " : Excepcion : "+ e.toString());
					//e.printStackTrace();
				}
				
				catch (AssertionError e)  {
					System.out.println(nLine + " : Assert : "+ e.toString());
					//e.printStackTrace();		
				}
			}
			s.close();
		} 
		catch (Exception e) {
			System.out.println("Excepción no controlada");
			e.printStackTrace();
		}
	}
}
