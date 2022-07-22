package artifact.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UploadExcel {

	public static void main(String[] args) throws Exception {

		try {

			// VARIABLE PARA MEDIR EL TIEMPO DE EJECUCIÓN DEL PROCESO
			long inicio = System.currentTimeMillis();

			// BUSCO EL ARCHIVO EXCEL EN LA RUTA.
			File file = new File("C:\\uploadExcel\\7747.xlsx");

			// GENERO EL ARCHIVO EN MEMORIA.
			InputStream inputStream = new FileInputStream(file);

			// CREO EL OBJETO WORKBOOK (OBJETO APACHE-POI) PASANDOLE EL OBJETO EN MEMORIA COMO PARAMETRO.
			Workbook workbook = WorkbookFactory.create(inputStream);

			// CREO EL OBJETO SHEET QUE REPRESENTA LA PRIMERA HOJA DEL EXCEL.
			Sheet sheet = workbook.getSheetAt(0);

//			// OBTENGO LA PRIMERA FILA (ENCABEZADOS / HEADER)
//			Row rowHeader = sheet.getRow(0);
//			
//			// RECORRER LAS CABECERAS. (SON 14 REGISTROS POR FILA)
//			for (int i = 0; i < rowHeader.getPhysicalNumberOfCells(); i++) {
//				
//				// CREO UNA CELDA EN CADA ELEMENTO PARA PODER LEER SU VALOR
//				Cell cellHeader = rowHeader.getCell(i);
//				
//				//IMPRIMO POR CONSOLA EL VALOR DE CADA CELDA
//				System.out.println(i+1 + " : " + cellHeader.getStringCellValue());
//			}

			// ARRAYLIST PARA GUARDAR LOS ELEMENTOS EN BDD
			ArrayList<Data> lista = new ArrayList<Data>();

			// ITERO EL EXCEL - PARTE EN 1 PORQUE NO QUIERO PROCESAR LOS TITULOS
			//for (int i = 1; i < sheet.getLastRowNum(); i++) {
			for (int i = 1; i < 100; i++) {

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

				// CREO EL OBJETO PARA ALMACENAR LOS DATOS EN MEMORIA Y ADEMÁS VALIDO LA ESTRUCTURA DE LOS DATOS DE EXCEL CON IF TERNIARIO
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

				// AGREGO EL OBJETO A LA LISTA PARA IR ALMACENANDO CADA FILA PARA SER INSERTADA DESPUES EN BDD
				lista.add(data);

//				//IMPRIMO POR CONSOLA EL VALOR DE CADA CELDA
//				System.out.println("Fila: " + i + " - 1.Área Administrativa: " + cellAreaAdministrativa);
//				System.out.println("Fila: " + i + " - 2.Situación: " + cellSituacion);
//				System.out.println("Fila: " + i + " - 3.ID Tramo Cable Óptico: " + cellIdTramoCableOptico);
//				System.out.println("Fila: " + i + " - 4.Código tramo cable óptico: " + cellcodigoTramoCableOptico);
//				System.out.println("Fila: " + i + " - 5.Cantidad fibras: " + cellCantidadFibras);
//				System.out.println("Fila: " + i + " - 6.Longitud estimada Total: " + cellLongitudEstimadaTotal);
//				System.out.println("Fila: " + i + " - 7.Propiedad: " + cellPropiedad);
//				System.out.println("Fila: " + i + " - 8.Propietario: " + cellPropietario);
//				System.out.println("Fila: " + i + " - 9.TRFO OT Actual: " + cellTrfoActual);
//				System.out.println("Fila: " + i + " - 10.TRFO OT Original: " + i + " , (10) " + cellTrfoOriginal);
//				System.out.println("Fila: " + i + " - 11.Orden trabajo: " + cellOrdenTrabajo);
//				System.out.println("Fila: " + i + " - 12.OT Fecha Implantación: " + cellOtFechaImplantacion);
//				System.out.println("Fila: " + i + " - 13.OT Estado actual: " + CellOtEstadoActual);
//				System.out.println("Fila: " + i + " - 14.Ruta: " + cellRuta);
//				System.out.println("Fila: " + i + " - 15.Usuario: " + cellUsuario);
//				System.out.println("");
			}
			
			
			// LOGICA PERSISTENCIA BDD
			Connection connection = ConectarBDD.conectar();
			
			//SE PREPARA LA CONSULTA SQL (PRUEBA - SOLO INSERTAREMOS EL PRIMER REGISTRO)
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DATA1 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, lista.get(0).getAreaAdministrativa());
			preparedStatement.setString(2, lista.get(0).getSituacion());
			preparedStatement.setString(3, lista.get(0).getiDTramoCableOptico());
			preparedStatement.setString(4, lista.get(0).getCodigoTramoCableOptico());
			preparedStatement.setDouble(5, lista.get(0).getCantidadFibras());
			preparedStatement.setString(6, lista.get(0).getLongitudEstimadaTotal());
			preparedStatement.setString(7, lista.get(0).getPropiedad());
			preparedStatement.setString(8, lista.get(0).getPropietario());
			preparedStatement.setString(9, lista.get(0).getTrfoOtActual());
			preparedStatement.setDouble(10, lista.get(0).getTrfoOtOriginal());
			preparedStatement.setString(11, lista.get(0).getOrdenDeTrabajo());
			preparedStatement.setString(12, lista.get(0).getoTFechaImplantacion());
			preparedStatement.setString(13, lista.get(0).getoTEstadoActual());
			preparedStatement.setString(14, lista.get(0).getRuta());
			preparedStatement.setString(15, lista.get(0).getUsuario());
			
			//EJECUTA LA QUERY DE INSERCIÓN
			int resultQuery = preparedStatement.executeUpdate();
			System.out.println("Informe BDD: " + resultQuery + " lineas insertadas");
			
			// CALCULO EN SEGUNDOS EN LA EJECUCIÓN DEL PROCESO
			long fin = System.currentTimeMillis();
			double segundos = (double) ((fin - inicio) / 1000);
			System.out.println("CARGA EXITOSA / " + lista.size() + " registros en " + segundos + " segundos");

		} catch (Exception e) {

			// CAPTURO EXCEPTION Y LA IMPRIMO EN CASO DE ERROR (NO DETIENE EL RUNTIME)
			e.printStackTrace();

			// LANZO UNA EXCEPCIÓN (SI DETIENE EL RUNTIME)
			throw new Exception();
		}

	}

}
