package artifact.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.opencsv.CSVReader;

public class UploadDocument {
	
	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) throws Exception {

		try {
			
			long inicio = System.currentTimeMillis();
									
			entityManagerFactory = Persistence.createEntityManagerFactory("persist_unit_jpa");
			EntityManager entityManagerExcel = entityManagerFactory.createEntityManager();
			
			// ################## LOGICA EXCEL ##################
			File fileExcel = new File("C:\\uploadExcel\\7747.xlsx");
			InputStream inputStreamExcel = new FileInputStream(fileExcel);
			Workbook workbook = WorkbookFactory.create(inputStreamExcel);
			Sheet sheet = workbook.getSheetAt(0);
			
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
				DataExcel dataExcel = new DataExcel();
				dataExcel.setId(i);
				dataExcel.setAreaAdministrativa((cellAreaAdministrativa != null ? cellAreaAdministrativa.getStringCellValue() : ""));
				dataExcel.setSituacion(cellSituacion != null ? String.valueOf(cellSituacion.getStringCellValue()) : "");
				dataExcel.setIdTramoCableOptico(cellIdTramoCableOptico != null ? String.valueOf(cellIdTramoCableOptico.getNumericCellValue()): "");
				dataExcel.setCodigoTramoCableOptico(cellcodigoTramoCableOptico != null ? cellcodigoTramoCableOptico.getStringCellValue() : "");
				dataExcel.setCantidadFibras(cellCantidadFibras != null ? String.valueOf(cellCantidadFibras.getNumericCellValue()) : "");
				dataExcel.setLongitudEstimadaTotal(cellLongitudEstimadaTotal != null? String.valueOf(cellLongitudEstimadaTotal.getNumericCellValue()): "");
				dataExcel.setPropiedad(cellPropiedad != null ? cellPropiedad.getStringCellValue() : "");
				dataExcel.setPropietario(cellPropietario != null ? cellPropietario.getStringCellValue() : "");
				dataExcel.setTrfoOtActual(cellTrfoActual != null ? cellTrfoActual.getStringCellValue() : "");
				dataExcel.setTrfoOtOriginal(cellTrfoOriginal != null ? String.valueOf(cellTrfoOriginal.getNumericCellValue()) : "");
				dataExcel.setOrdenDeTrabajo(cellOrdenTrabajo != null ? cellOrdenTrabajo.getStringCellValue() : "");
				dataExcel.setOtFechaImplantacion(cellOtFechaImplantacion != null ? cellOtFechaImplantacion.getStringCellValue() : "");
				dataExcel.setOtEstadoActual(CellOtEstadoActual != null ? CellOtEstadoActual.getStringCellValue() : "");
				dataExcel.setRuta(cellRuta != null ? cellRuta.getStringCellValue() : "");
				dataExcel.setUsuario(cellUsuario != null ? cellUsuario.getStringCellValue() : "");
				
				entityManagerExcel.getTransaction().begin();
				entityManagerExcel.persist(dataExcel);
				entityManagerExcel.getTransaction().commit();
							
			}
			
			// CIERRO ENTITY MANAGER DE LOS EXCEL
			entityManagerExcel.close();
			
			
			// ################## LOGICA CSV ##################
			String fileCSV = "C:\\uploadExcel\\Junio.csv";
			CSVReader csvReader = new CSVReader(new FileReader(fileCSV));
			
			// OBTENGO UN NUEVO GESTOR DE PERSISTENCIA
			EntityManager entityManagerCSV = entityManagerFactory.createEntityManager();
			
			// TRANSFORMO EL OBJETO A UNA LISTA ITERABLE
			List<String[]> lista = csvReader.readAll();
			
			// SON 47 ELEMENTOS PERO SOLO CREE UN DTO CON 12 ELEMENTOS POR AHORA PARA PROBAR
			for(int i = 1 ; i < lista.size() ; i++) {
				
				DataCSV dataCSV = new DataCSV();
				dataCSV.setId(i);
				dataCSV.setIdentificador(lista.get(i)[0]);
				dataCSV.setNombreProyecto(lista.get(i)[1]);
				dataCSV.setDirrecion(lista.get(i)[2]);
				dataCSV.setAltura(lista.get(i)[3]);
				dataCSV.setCantidadHp(lista.get(i)[4]);
				dataCSV.setEstadoStb(lista.get(i)[5]);
				dataCSV.setAgencia(lista.get(i)[6]);
				dataCSV.setOeccComuna(lista.get(i)[7]);
				dataCSV.setEmpresaAdjudicada(lista.get(i)[8]);
				dataCSV.setEmpresaColaboradora(lista.get(i)[9]);
				dataCSV.setSemana(lista.get(i)[10]);
				dataCSV.setSemanaReal(lista.get(i)[11]);
				dataCSV.setSmell(lista.get(i)[12]);
				dataCSV.setTargetReal(lista.get(i)[13]);
				dataCSV.setTarget(lista.get(i)[14]);
				dataCSV.setAnoCumplimiento(lista.get(i)[15]);
				dataCSV.setOficinaCentralFttx(lista.get(i)[16]);
				dataCSV.set_16LiberadoAVentas(lista.get(i)[17]);
				dataCSV.setRegion(lista.get(i)[18]);
				dataCSV.setTipoProyecto(lista.get(i)[19]);
				dataCSV.setPep2(lista.get(i)[20]);
				dataCSV.setOeccPep2(lista.get(i)[21]);
				
				entityManagerCSV.getTransaction().begin();
				entityManagerCSV.persist(dataCSV);
				entityManagerCSV.getTransaction().commit();
				
			}
			
			// CERRAMOS EL OBJETO PARA PROCESAR CSV Y EN ENTITY MANAGER DE LOS CSV
			csvReader.close();
			entityManagerCSV.close();
			
								
			long fin = System.currentTimeMillis();
			double segundos = (double) ((fin - inicio) / 1000);
			System.out.println("CARGA EXITOSA / " + segundos + " segundos");
						
			

		} catch (Exception e) {

			// CAPTURO EXCEPTION Y LA IMPRIMO EN CASO DE ERROR (NO DETIENE EL RUNTIME).
			e.printStackTrace();

			// LANZO UNA EXCEPCI�N (SI DETIENE EL RUNTIME).
			throw new Exception(e);
		}

	}

}
