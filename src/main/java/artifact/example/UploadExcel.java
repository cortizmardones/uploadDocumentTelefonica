package artifact.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UploadExcel {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) throws Exception {

		try {
			
			//####################### VARIABLES PARA METRICAS DEL PROCESO #######################
			
			// VARIABLE PARA MEDIR EL TIEMPO DE EJECUCI�N DEL PROCESO
			long inicio = System.currentTimeMillis();
						
			// CONTADORES Y ACUMULADORES
			int j = 0;
			int contadorInsercionesBDD = 0;
			int resultQuery = 0;
			
			//####################### OBTENGO LA INSTANCIA ESTATICA DE CONEXION A LA BDD #######################
			
			// ABRO LA CONEXION A LA BDD
			Connection connection = ConectarBDD.conectar();
			
			// OBTENGO LA CONFIGURACION DEL ARCHIVO HIBERNATE (META-INF/PERSISTENCE.XML)
			entityManagerFactory = Persistence.createEntityManagerFactory("persist_unit_jpa");
			entityManager = entityManagerFactory.createEntityManager();
			
			//####################### INICIO PROCESAMIENTO ARCHIVO EXCEL#######################

			// BUSCO EL ARCHIVO EXCEL EN LA RUTA.
			File file = new File("C:\\uploadExcel\\7747.xlsx");

			// GENERO EL ARCHIVO EN MEMORIA.
			InputStream inputStream = new FileInputStream(file);

			// CREO EL OBJETO WORKBOOK (OBJETO APACHE-POI) PASANDOLE EL OBJETO EN MEMORIA COMO PARAMETRO.
			Workbook workbook = WorkbookFactory.create(inputStream);

			// CREO EL OBJETO SHEET QUE REPRESENTA LA PRIMERA HOJA DEL EXCEL.
			Sheet sheet = workbook.getSheetAt(0);
			
			// ARRAYLIST PARA GUARDAR LOS ELEMENTOS DEL EXCEL COMPLETO Y FINALMENTE ALMACENARLOS EN LA BDD.
			ArrayList<Data> lista = new ArrayList<Data>();
			ArrayList<Data2> lista2 = new ArrayList<Data2>();
			
			// ITERO EL EXCEL - PARTE EN 1 PORQUE NO QUIERO PROCESAR LOS TITULOS.
			for (int i = 1; i < sheet.getLastRowNum()-2; i++) {
			//for (int i = 1; i < 10; i++) {

				Row rowData = sheet.getRow(i);
				Cell cellAreaAdministrativa = rowData.getCell(0);
				Cell cellSituacion = rowData.getCell(1);
				Cell cellIdTramoCableOptico = rowData.getCell(2);
				Cell cellcodigoTramoCableOptico = rowData.getCell(3);
				Cell cellCantidadFibras = rowData.getCell(4);
				Cell cellLongitudEstimadaTotal = rowData.getCell(5);
				Cell cellPropiedad = rowData.getCell(6);
				Cell cellPropietario = rowData.getCell(7);
				Cell cellTrfoActual = rowData.getCell(8);
				Cell cellTrfoOriginal = rowData.getCell(9);
				Cell cellOrdenTrabajo = rowData.getCell(10);
				Cell cellOtFechaImplantacion = rowData.getCell(11);
				Cell CellOtEstadoActual = rowData.getCell(12);
				Cell cellRuta = rowData.getCell(13);
				Cell cellUsuario = rowData.getCell(14);

				// CREO EL OBJETO PARA ALMACENAR LOS DATOS EN MEMORIA Y ADEM�S VALIDO LA ESTRUCTURA DE LOS DATOS DE EXCEL CON IF TERNARIO.
				Data data = new Data();
				data.setAreaAdministrativa((cellAreaAdministrativa != null ? cellAreaAdministrativa.getStringCellValue() : ""));
				data.setSituacion(cellSituacion != null ? String.valueOf(cellSituacion.getStringCellValue()) : "");
				data.setiDTramoCableOptico(cellIdTramoCableOptico != null ? String.valueOf(cellIdTramoCableOptico.getNumericCellValue()): "");
				data.setCodigoTramoCableOptico(cellcodigoTramoCableOptico != null ? cellcodigoTramoCableOptico.getStringCellValue() : "");
				data.setCantidadFibras(cellCantidadFibras != null ? cellCantidadFibras.getNumericCellValue() : 0);
				data.setLongitudEstimadaTotal(cellLongitudEstimadaTotal != null? String.valueOf(cellLongitudEstimadaTotal.getNumericCellValue()): "");
				data.setPropiedad(cellPropiedad != null ? cellPropiedad.getStringCellValue() : "");
				data.setPropietario(cellPropietario != null ? cellPropietario.getStringCellValue() : "");
				data.setTrfoOtActual(cellTrfoActual != null ? cellTrfoActual.getStringCellValue() : "");
				data.setTrfoOtOriginal(cellTrfoOriginal != null ? cellTrfoOriginal.getNumericCellValue() : 0);
				data.setOrdenDeTrabajo(cellOrdenTrabajo != null ? cellOrdenTrabajo.getStringCellValue() : "");
				data.setoTFechaImplantacion(cellOtFechaImplantacion != null ? cellOtFechaImplantacion.getStringCellValue() : "");
				data.setoTEstadoActual(CellOtEstadoActual != null ? CellOtEstadoActual.getStringCellValue() : "");
				data.setRuta(cellRuta != null ? cellRuta.getStringCellValue() : "");
				data.setUsuario(cellUsuario != null ? cellUsuario.getStringCellValue() : "");
				
				// AGREGO EL OBJETO A LA LISTA PARA IR ALMACENANDO CADA FILA PARA SER INSERTADA DESPUES EN BDD.
				lista.add(data);
				
				// SE PREPARA LA CONSULTA SQL. (JDBC CLÁSICO)
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DATA1 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, j+1);
				preparedStatement.setString(2, lista.get(j).getAreaAdministrativa());
				preparedStatement.setString(3, lista.get(j).getSituacion());
				preparedStatement.setString(4, lista.get(j).getiDTramoCableOptico());
				preparedStatement.setString(5, lista.get(j).getCodigoTramoCableOptico());
				preparedStatement.setDouble(6, lista.get(j).getCantidadFibras());
				preparedStatement.setString(7, lista.get(j).getLongitudEstimadaTotal());
				preparedStatement.setString(8, lista.get(j).getPropiedad());
				preparedStatement.setString(9, lista.get(j).getPropietario());
				preparedStatement.setString(10, lista.get(j).getTrfoOtActual());
				preparedStatement.setDouble(11, lista.get(j).getTrfoOtOriginal());
				preparedStatement.setString(12, lista.get(j).getOrdenDeTrabajo());
				preparedStatement.setString(13, lista.get(j).getoTFechaImplantacion());
				preparedStatement.setString(14, lista.get(j).getoTEstadoActual());
				preparedStatement.setString(15, lista.get(j).getRuta());
				preparedStatement.setString(16, lista.get(j).getUsuario());
				
				// EJECUTA LA QUERY DE INSERCI�N.
				resultQuery = preparedStatement.executeUpdate();
				
				// AGREGO LOGICA DE CONTADOR DE INSERCIONES EN BDD.
				contadorInsercionesBDD = contadorInsercionesBDD + resultQuery;
				
				
				// CREO EL OBJETO PARA ALMACENAR LOS DATOS EN MEMORIA Y ADEM�S VALIDO LA ESTRUCTURA DE LOS DATOS DE EXCEL CON IF TERNARIO.
				Data2 data2 = new Data2();
				data2.setId(j+1);
				data2.setAreaAdministrativa((cellAreaAdministrativa != null ? cellAreaAdministrativa.getStringCellValue() : ""));
				data2.setSituacion(cellSituacion != null ? String.valueOf(cellSituacion.getStringCellValue()) : "");
				data2.setiDTramoCableOptico(cellIdTramoCableOptico != null ? String.valueOf(cellIdTramoCableOptico.getNumericCellValue()): "");
				data2.setCodigoTramoCableOptico(cellcodigoTramoCableOptico != null ? cellcodigoTramoCableOptico.getStringCellValue() : "");
				data2.setCantidadFibras(cellCantidadFibras != null ? String.valueOf(cellCantidadFibras.getNumericCellValue()) : "");
				data2.setLongitudEstimadaTotal(cellLongitudEstimadaTotal != null? String.valueOf(cellLongitudEstimadaTotal.getNumericCellValue()): "");
				data2.setPropiedad(cellPropiedad != null ? cellPropiedad.getStringCellValue() : "");
				data2.setPropietario(cellPropietario != null ? cellPropietario.getStringCellValue() : "");
				data2.setTrfoOtActual(cellTrfoActual != null ? cellTrfoActual.getStringCellValue() : "");
				data2.setTrfoOtOriginal(cellTrfoOriginal != null ? String.valueOf(cellTrfoOriginal.getNumericCellValue()) : "");
				data2.setOrdenDeTrabajo(cellOrdenTrabajo != null ? cellOrdenTrabajo.getStringCellValue() : "");
				data2.setoTFechaImplantacion(cellOtFechaImplantacion != null ? cellOtFechaImplantacion.getStringCellValue() : "");
				data2.setoTEstadoActual(CellOtEstadoActual != null ? CellOtEstadoActual.getStringCellValue() : "");
				data2.setRuta(cellRuta != null ? cellRuta.getStringCellValue() : "");
				data2.setUsuario(cellUsuario != null ? cellUsuario.getStringCellValue() : "");
				
				// AGREGO EL OBJETO A LA LISTA PARA IR ALMACENANDO CADA FILA PARA SER INSERTADA DESPUES EN BDD.
				lista2.add(data2);
				
				// TENGO QUE HACER EL METODO TRANSACTIONAL PARA PODER OPERAR CON NATIVE QUERYS
				entityManager.getTransaction().begin();
				
				// SE PREPARA LA CONSULTA SQL Y SE EJCUTA EN EL MOMENTO. (JPA)
			    entityManager.createNativeQuery("INSERT INTO DATA2 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
			    	.setParameter(1, lista2.get(j).getId())
			    	.setParameter(2, lista2.get(j).getAreaAdministrativa())
			    	.setParameter(3, lista2.get(j).getSituacion())
			    	.setParameter(4, lista2.get(j).getiDTramoCableOptico())
			    	.setParameter(5, lista2.get(j).getCodigoTramoCableOptico())
			    	.setParameter(6, lista2.get(j).getCantidadFibras())
			    	.setParameter(7, lista2.get(j).getLongitudEstimadaTotal())
			    	.setParameter(8, lista2.get(j).getPropiedad())
			    	.setParameter(9, lista2.get(j).getPropietario())
					.setParameter(10, lista2.get(j).getTrfoOtActual())
					.setParameter(11, lista2.get(j).getTrfoOtOriginal())
					.setParameter(12, lista2.get(j).getOrdenDeTrabajo())
					.setParameter(13, lista2.get(j).getoTFechaImplantacion())
					.setParameter(14, lista2.get(j).getoTEstadoActual())
					.setParameter(15, lista2.get(j).getRuta())
					.setParameter(16, lista2.get(j).getUsuario())
			      .executeUpdate();
			    
			    // DIGO QUE TERMINO LA TRANSACTION
			    entityManager.getTransaction().commit();
				
				// AUMENTO CONTADOR PARA ITERAR INSERCIONES EN BDD.
				j++;
				
			}
						
			// INFORME INSERCIONES SQL.
			System.out.println("Informe BDD: " + contadorInsercionesBDD + " lineas insertadas");
			
			// CALCULO EN SEGUNDOS EN LA EJECUCI�N DEL PROCESO.
			long fin = System.currentTimeMillis();
			double segundos = (double) ((fin - inicio) / 1000);
			System.out.println("CARGA EXITOSA / " + lista.size() + " registros en " + segundos + " segundos");
			
			// LIMPIO LA LISTA PARA LIBERAR MEMORIA.
			lista.clear();
			
			// CERRAR CONEXION.
			connection.close();

		} catch (Exception e) {

			// CAPTURO EXCEPTION Y LA IMPRIMO EN CASO DE ERROR (NO DETIENE EL RUNTIME).
			e.printStackTrace();

			// LANZO UNA EXCEPCI�N (SI DETIENE EL RUNTIME).
			throw new Exception();
		}

	}

}



////IMPRIMO POR CONSOLA EL VALOR DELOS ENCABEZADOS (NO BORRAR)
//// OBTENGO LA PRIMERA FILA (ENCABEZADOS / HEADER)
//Row rowHeader = sheet.getRow(0);
//
//// RECORRER LAS CABECERAS. (SON 14 REGISTROS POR FILA)
//for (int i = 0; i < rowHeader.getPhysicalNumberOfCells(); i++) {
//	
//	// CREO UNA CELDA EN CADA ELEMENTO PARA PODER LEER SU VALOR
//	Cell cellHeader = rowHeader.getCell(i);
//	
//	//IMPRIMO POR CONSOLA EL VALOR DE CADA CELDA
//	System.out.println(i+1 + " : " + cellHeader.getStringCellValue());
//}



////IMPRIMO POR CONSOLA EL VALOR DE CADA CELDA (NO BORRAR)
//System.out.println("Fila: " + i + " - 1.�rea Administrativa: " + cellAreaAdministrativa);
//System.out.println("Fila: " + i + " - 2.Situaci�n: " + cellSituacion);
//System.out.println("Fila: " + i + " - 3.ID Tramo Cable �ptico: " + cellIdTramoCableOptico);
//System.out.println("Fila: " + i + " - 4.C�digo tramo cable �ptico: " + cellcodigoTramoCableOptico);
//System.out.println("Fila: " + i + " - 5.Cantidad fibras: " + cellCantidadFibras);
//System.out.println("Fila: " + i + " - 6.Longitud estimada Total: " + cellLongitudEstimadaTotal);
//System.out.println("Fila: " + i + " - 7.Propiedad: " + cellPropiedad);
//System.out.println("Fila: " + i + " - 8.Propietario: " + cellPropietario);
//System.out.println("Fila: " + i + " - 9.TRFO OT Actual: " + cellTrfoActual);
//System.out.println("Fila: " + i + " - 10.TRFO OT Original: " + i + " , (10) " + cellTrfoOriginal);
//System.out.println("Fila: " + i + " - 11.Orden trabajo: " + cellOrdenTrabajo);
//System.out.println("Fila: " + i + " - 12.OT Fecha Implantaci�n: " + cellOtFechaImplantacion);
//System.out.println("Fila: " + i + " - 13.OT Estado actual: " + CellOtEstadoActual);
//System.out.println("Fila: " + i + " - 14.Ruta: " + cellRuta);
//System.out.println("Fila: " + i + " - 15.Usuario: " + cellUsuario);
//System.out.println("");
