package artifact.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
			
			long inicio = System.currentTimeMillis();
									
			entityManagerFactory = Persistence.createEntityManagerFactory("persist_unit_jpa");
			entityManager = entityManagerFactory.createEntityManager();
			
			File file = new File("C:\\uploadExcel\\7747.xlsx");
			InputStream inputStream = new FileInputStream(file);

			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			
			int j = 0;
						
			//for (int i = 1; i < sheet.getLastRowNum()-2; i++) {
			for (int i = 1; i < 101; i++) {

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
							
				entityManager.getTransaction().begin();
				entityManager.persist(data2);
			    entityManager.getTransaction().commit();
				
				j++;
				
			}
								
			long fin = System.currentTimeMillis();
			double segundos = (double) ((fin - inicio) / 1000);
			System.out.println("CARGA EXITOSA / " + segundos + " segundos");
						
			entityManager.close();

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
