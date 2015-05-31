package pe.gob.sunat.servicio2.registro.electronico.comppago.guiaremision.controlbienes.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.gob.sunat.servicio2.registro.electronico.comppago.guiaremision.controlbienes.model.domain.DocumentoRelacionado;
import pe.gob.sunat.servicio2.registro.electronico.comppago.guiaremision.controlbienes.model.domain.GuiaRemision;
import pe.gob.sunat.servicio2.registro.electronico.comppago.guiaremision.controlbienes.model.domain.PkGuia;
import pe.gob.sunat.servicio2.registro.electronico.comppago.guiaremision.controlbienes.model.domain.Vehiculo;
import pe.gob.sunat.servicio2.registro.electronico.comppago.guiaremision.controlbienes.utils.Constantes;

import com.lowagie.text.Document;

public class DocumentoElectronicoServiceImpl implements DocumentoElectronicoService {
	protected final Log log = LogFactory.getLog(getClass());
	public static final int LENGTH_BUFFER = 1024;

	private Properties propiedades;

	@Override
	public Byte[] generarCodigoBarras(GuiaRemision guiaRemision) {
		// TODO: implement
		return null;
	}

	@Override
	public Byte[] generarFirma(java.lang.StringBuffer xmlGuia) {
		// TODO: implement
		return null;
	}

	@Override
	public Byte[] generarXml(GuiaRemision guiaRemision) {
		// TODO: implement
		return null;
	}

	@Override
	public byte[] generarPDF(Map<String,Object> configData, Collection fieldData, Map<String, Object> paramData) {

		String jasperFile = null;
		byte[] pdfBytes = null;

		jasperFile = propiedades.getProperty("jasperDirectory") + propiedades.getProperty("jasperName") + ".jasper";

		paramData.put("net.sf.jasperreports.engine.export.JRPdfExporterParameter.METADATA_AUTHOR", "sunat.gob.pe");
		paramData.put("net.sf.jasperreports.engine.export.JRPdfExporterParameter.METADATA_CREATOR", "SUNAT Java GenDoc derechos reservados");
		paramData.put("net.sf.jasperreports.engine.export.JRPdfExporterParameter.INPUT_FILE_NAME", propiedades.getProperty("jasperDirectory") + propiedades.getProperty("jasperName") + ".jasper");
	    if (configData.containsKey("nombreFileEntrada")){
	    	paramData.put("net.sf.jasperreports.engine.export.JRPdfExporterParameter.INPUT_FILE_NAME", propiedades.getProperty("jasperDirectory") + configData.get("nombreFileEntrada")  + ".jasper");
	    	jasperFile = propiedades.getProperty("jasperDirectory") + configData.get("nombreFileEntrada") + ".jasper";
	    }
	    if(configData.containsKey("metadata_asunto")){
	    	paramData.put("net.sf.jasperreports.engine.export.JRPdfExporterParameter.METADATA_SUBJECT", configData.get("metadata_asunto"));
	    }
	    if(configData.containsKey("metadata_titulo")){
	    	paramData.put("net.sf.jasperreports.engine.export.JRPdfExporterParameter.METADATA_TITLE", configData.get("metadata_titulo"));
	    }

	    paramData.put("SUBREPORT_DIR", propiedades.getProperty("jasperDirectory"));
		try {
			if(fieldData == null){
				fieldData = new ArrayList<Object>();
			}
			JasperPrint print = JasperFillManager.fillReport(jasperFile, paramData, new JRBeanCollectionDataSource(fieldData));
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
		    // imprimir por default
			//exporter.setParameter(JRPdfExporterParameter.PDF_JAVASCRIPT, "this.print({bUI: true,bSilent: false,bShrinkToFit: true});");
			exporter.exportReport();
			pdfBytes = outputStream.toByteArray();

		} catch (JRException e) {
			throw new RuntimeException("ocurrio un error al crear el pdf",e);
		}

		return pdfBytes;
	}

	@Override
	public byte[] generarPDFGuiaRemisionTransportista(GuiaRemision guia, String firma) {
		Map<String,Object> configuracion = new HashMap<String, Object>();
		if (log.isDebugEnabled()){ log.debug("generarPDFGuiaRemisionTransportista(" +  guia.toString() + "," + firma);}
		configuracion.put("metadata_asunto","Guia de remision electronica transportista");
		configuracion.put("metadata_titulo","Guia de remision electronica transportista");
		Map<String, Object> parametros = new HashMap<String, Object>();
		configuracion.put("nombreFileEntrada","rptGreTransportista");
		parametros.put("PARAMETER_COD_TIPO_GUIA", guia.getPkGuia().getTipoGuia());

		if(guia.getPkGuia().getTipoGuia().equals("62")) {
			parametros.put("PARAMETRO_NRO_TRANSP_GUIA_REF", "");
			parametros.put("PARAMETRO_TIPO_GUIA", "GU\u00CDA DE REMISI\u00D3N ELECTR\u00D3NICA TRANSPORTISTA");//
			parametros.put("PARAMETRO_NRO_GUIA_REF", guia.getDocumentoRelacionados().get(0).getNumeroDocumento());

		}
		if (guia.getTipoTramo() !=null && !guia.getTipoTramo().equals("")){
			if (guia.getTipoTramo().equals("1")){
				parametros.put("PARAMETER_COD_TIPO_TRAMO", guia.getTipoTramo() +  " - INICIAL");
			}
			if (guia.getTipoTramo().equals("2")){
				parametros.put("PARAMETER_COD_TIPO_TRAMO", guia.getTipoTramo() +  " - INTERMEDIO");
			}
			if (guia.getTipoTramo().equals("3")){
				parametros.put("PARAMETER_COD_TIPO_TRAMO", guia.getTipoTramo() +  " - FINAL");
			}
		}


		parametros.put("PARAMETRO_CONDUCTORES", guia.getConductores() );
		parametros.put("PARAMETRO_TRANSPORTE", guia.getVehiculos() );
		parametros.put("PARAMETRO_FEC_HORA_PARTIDA", guia.getFechaInicioTraslado() );
		//msf
		parametros.put("PARAMETRO_COD_VERIFICACION", guia.getCodigoVerificacion() );

		if (guia.getTransportista().getPartidaRegMtc()!=null && !guia.getTransportista().getPartidaRegMtc().equals("")){
			parametros.put("PARAMETRO_PARTIDA_MTC", "Partida Registral MTC - " + guia.getTransportista().getPartidaRegMtc());
		}else{
			parametros.put("PARAMETRO_PARTIDA_MTC", "");
		}
		//msf

		if(guia.getPkGuia().getTipoGuia().equals("63")) {

			parametros.put("PARAMETRO_NRO_TRANSP_GUIA_REF",  guia.getGuiaOriginal().toStringNumeroGuia());
			parametros.put("PARAMETRO_MODALIDAD_TRANSPORTE", "P\u00FAblico");
			parametros.put("PARAMETRO_TIPO_GUIA", "GU\u00CDA DE REMISI\u00D3N ELECTR\u00D3NICA TRANSPORTISTA COMPLEMENTARIA");//
			parametros.put("PARAMETRO_MOT_TRANSPORTE", guia.getDesMotivoEmision());
			parametros.put("PARAMETRO_NRO_GUIA_REF", guia.getDocumentoRelacionados().get(1).getNumeroDocumento());

		}

		parametros.put("PARAMETRO_FEC_EMIS", guia.getFechaEmision());
		parametros.put("PARAMETRO_NOMB_REMITENTE", guia.getTransportista().getNombres());

		parametros.put("PARAMETRO_DIREC_REMITENTE", guia.getTransportista().getDomicilio().getDireccion());// obtener de ddp
		parametros.put("PARAMETRO_UBIGEO_REMITENTE", guia.getTransportista().getDomicilio().getUbigeo().toString());

		parametros.put("PARAMETRO_NUM_RUC", guia.getTransportista().getNumeroDocumento());
		parametros.put("PARAMETRO_NRO_GUIA", guia.getPkGuia().getNumeroGuia().toString());

		String puntoPartida = guia.getPuntoPartida().getDireccion();
		if(guia.getPuntoPartida().getUbigeo()!=null){
			puntoPartida += ", " + guia.getPuntoPartida().getUbigeo().toString();
		}
		parametros.put("PARAMETRO_PTO_PARTIDA", puntoPartida);

		String puntoLlegada = guia.getPuntoLlegada().getDireccion();
		if(guia.getPuntoLlegada().getUbigeo()!=null){
			puntoLlegada += ", " + guia.getPuntoLlegada().getUbigeo().toString();
		}
		parametros.put("PARAMETRO_PTO_LLEGADA", puntoLlegada);

		parametros.put("PARAMETRO_NOMB_DESTINATARIO", guia.getRemitente().getNombres());

		parametros.put("PARAMETRO_DOC_DESTINATARIO", guia.getRemitente().getDocumentoCompleto());
		parametros.put("PARAMETRO_OBS", guia.getObservacion());

		parametros.put("PARAMETRO_TRANSBORDO", guia.getTransbordo());		
		parametros.put("PARAMETRO_SUBCONTRATADO", guia.getTransportista().getSubContratado());
		
		parametros.put("PARAMETRO_BAR_CODE", guia.generarCodigoBarras(firma));

		if (log.isDebugEnabled()){ log.debug("Datos a imprimir: " +  parametros);}


		return generarPDF(configuracion, guia.getItems(), parametros);

	}
	@Override
	public byte[] generarPDFGuiaRemisionRemitente(GuiaRemision guia, String firma) {
		Map<String,Object> configuracion = new HashMap<String, Object>();
		//configuracion.put("nombreFileEntrada","");
		configuracion.put("metadata_asunto","Guia de remision electronica remitente");
		configuracion.put("metadata_titulo","Guia de remision electronica remitente");
		Map<String, Object> parametros = null;
		if(Constantes.TRANSPORTE_PRIVADO.equals(guia.getFormaTraslado())) {
			configuracion.put("nombreFileEntrada","rptGreRemitentePrivado");
			parametros = guiaRemisionRemitentePrivada(guia);
		}

		if(Constantes.TRANSPORTE_PUBLICO.equals(guia.getFormaTraslado())) {
			parametros = guiaRemisionRemitentePublico(guia);
		}
		parametros.put("PARAMETRO_CODIGO_VERIFICACION", guia.getCodigoVerificacion());
		parametros.put("PARAMETRO_FEC_EMIS", guia.getFechaEmision());
		parametros.put("PARAMETRO_NOMB_REMITENTE", guia.getRemitente().getNombres());
		parametros.put("PARAMETRO_DIREC_REMITENTE", guia.getRemitente().getDomicilio().getDireccion());// obtener de ddp
		parametros.put("PARAMETRO_UBIGEO_REMITENTE", guia.getRemitente().getDomicilio().getUbigeo().toString());
		parametros.put("PARAMETRO_NUM_RUC", guia.getRemitente().getNumeroDocumento());
		parametros.put("PARAMETRO_NRO_GUIA", guia.getPkGuia().getNumeroGuia().toString());
		if(guia.getGuiaOriginal() != null){
			parametros.put("PARAMETRO_GUIA_ORIGINAL", guia.getGuiaOriginal().toStringNumeroGuia());
		}

		String puntoPartida = guia.getPuntoPartida().getDireccion();
		if(guia.getPuntoPartida().getUbigeo()!=null){
			puntoPartida += ", " + guia.getPuntoPartida().getUbigeo().toString();
		}
		parametros.put("PARAMETRO_PTO_PARTIDA", puntoPartida);

		String puntoLlegada = guia.getPuntoLlegada().getDireccion();
		if(guia.getPuntoLlegada().getUbigeo()!=null){
			puntoLlegada += ", " + guia.getPuntoLlegada().getUbigeo().toString();
		}
		parametros.put("PARAMETRO_PTO_LLEGADA", puntoLlegada);

		parametros.put("PARAMETRO_MOT_TRANSPORTE", guia.getDesMotivoTraslado());
		parametros.put("PARAMETRO_RUTA_FISCAL", guia.getRutasFiscales());
		parametros.put("PARAMETRO_NOMB_DESTINATARIO", guia.getDestinatario().getNombres());
		parametros.put("PARAMETRO_DOC_DESTINATARIO", guia.getDestinatario().getDocumentoCompleto());
		parametros.put("PARAMETRO_OBS", guia.getObservacion());
		parametros.put("PARAMETRO_DAM", guia.numerDAM());
		parametros.put("PARAMETRO_TRANSBORDO", guia.getTransbordo());
		parametros.put("PARAMETRO_BAR_CODE", guia.generarCodigoBarras(firma));
		return generarPDF(configuracion, guia.getItems(), parametros);

	}

	@Override
	public byte[] generarPDFGuiaRemisionRemitenteComplementaria(GuiaRemision guia, String firma) {
		Map<String,Object> configuracion = new HashMap<String, Object>();
		//configuracion.put("nombreFileEntrada","");
		configuracion.put("metadata_asunto","Guia de remision electronica remitente complementaria");
		configuracion.put("metadata_titulo","Guia de remision electronica remitente complementaria");
		Map<String, Object> parametros = null;
		if(Constantes.TRANSPORTE_PRIVADO.equals(guia.getFormaTraslado())) {
			configuracion.put("nombreFileEntrada","rptGreRemitenteComplementariaPrivado");
			parametros = guiaRemisionRemitenteCompleMentariaPrivada(guia);
		}

		if(Constantes.TRANSPORTE_PUBLICO.equals(guia.getFormaTraslado())) {
			configuracion.put("nombreFileEntrada","rptGreRemitenteComplementariaPublico");
			parametros = guiaRemisionRemitenteComplementariaPublico(guia);
		}
		parametros.put("PARAMETRO_CODIGO_VERIFICACION", guia.getCodigoVerificacion());
		parametros.put("PARAMETRO_FEC_EMIS", guia.getFechaEmision());
		parametros.put("PARAMETRO_NOMB_REMITENTE", guia.getRemitente().getNombres());
		parametros.put("PARAMETRO_DIREC_REMITENTE", guia.getRemitente().getDomicilio().getDireccion());// obtener de ddp
		parametros.put("PARAMETRO_UBIGEO_REMITENTE", guia.getRemitente().getDomicilio().getUbigeo().toString());
		parametros.put("PARAMETRO_NUM_RUC", guia.getRemitente().getNumeroDocumento());
		parametros.put("PARAMETRO_NRO_GUIA", guia.getPkGuia().getNumeroGuia().toString());

		if(guia.getPuntoPartida() != null) {
			String puntoPartida = guia.getPuntoPartida().getDireccion();
			if(guia.getPuntoPartida().getUbigeo()!=null){
				puntoPartida += ", " + guia.getPuntoPartida().getUbigeo().toString();
			}

			parametros.put("PARAMETRO_PTO_PARTIDA", puntoPartida);
		}

		if(guia.getPuntoLlegada() != null) {
			String puntoLlegada = guia.getPuntoLlegada().getDireccion();
			if(guia.getPuntoLlegada().getUbigeo()!=null){
				puntoLlegada += ", " + guia.getPuntoLlegada().getUbigeo().toString();
			}
			parametros.put("PARAMETRO_PTO_LLEGADA", puntoLlegada);
		}

		parametros.put("PARAMETRO_GUIA_ORIGINAL", guia.getGuiaOriginal().toStringNumeroGuia());
		parametros.put("PARAMETRO_MOT_EMISION", guia.getDesMotivoEmision());

		//parametros.put("PARAMETRO_RUTA_FISCAL", guia.getRutasFiscales());
		parametros.put("PARAMETRO_OBS", guia.getObservacion());

		parametros.put("PARAMETRO_BAR_CODE", guia.generarCodigoBarras(firma));
		return generarPDF(configuracion, guia.getConductores(), parametros);

	}

	private Map<String, Object> guiaRemisionRemitentePublico(GuiaRemision guia) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("PARAMETRO_NOMB_TRANSPORTISTA", guia.getTransportista().getNombres());
		parametros.put("PARAMETRO_RUC_TRANSPORTISTA", guia.getTransportista().getNumeroDocumento());
		parametros.put("PARAMETRO_MODALIDAD_TRANSPORTE", "P\u00FAblico");
		parametros.put("PARAMETRO_FEC_HORA_PARTIDA", guia.getFechaEntregaTransportista());
		parametros.put("PARAMETRO_SUBCONTRATADO", guia.getTransportista().getSubContratado());
		return parametros;
	}

	private Map<String, Object> guiaRemisionRemitentePrivada(GuiaRemision guia) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("PARAMETRO_CONDUCTORES", guia.getConductores() );
		parametros.put("PARAMETRO_MODALIDAD_TRANSPORTE", "Privado" );
		parametros.put("PARAMETRO_FEC_HORA_PARTIDA", guia.getFechaInicioTraslado() );
		if(CollectionUtils.isNotEmpty(guia.getVehiculos())){
			Vehiculo vehiculo = guia.getVehiculos().get(0);
			parametros.put("PARAMETRO_UNIDAD_TRANSPORTE", (vehiculo.getDescripcionTipo() + ", " + vehiculo.getMarca() + ", " + vehiculo.getPlaca()));
		}
		return parametros;
	}

	private Map<String, Object> guiaRemisionRemitenteComplementariaPublico(GuiaRemision guia) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(guia.getTransportista() != null){
			parametros.put("PARAMETRO_NOMB_TRANSPORTISTA", guia.getTransportista().getNombres());
			parametros.put("PARAMETRO_RUC_TRANSPORTISTA", guia.getTransportista().getNumeroDocumento());
		}
		parametros.put("PARAMETRO_MODALIDAD_TRANSPORTE", "P\u00FAblico");
		parametros.put("PARAMETRO_FEC_HORA_PARTIDA", guia.getFechaEntregaTransportista());//

		return parametros;
	}

	private Map<String, Object> guiaRemisionRemitenteCompleMentariaPrivada(GuiaRemision guia) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("PARAMETRO_MODALIDAD_TRANSPORTE", "Privado" );
		parametros.put("PARAMETRO_FEC_HORA_PARTIDA", guia.getFechaInicioTraslado() );
		if(CollectionUtils.isNotEmpty(guia.getVehiculos())){
			Vehiculo vehiculo = guia.getVehiculos().get(0);
			parametros.put("PARAMETRO_UNIDAD_TRANSPORTE", (vehiculo.getDescripcionTipo() + ", " + vehiculo.getMarca() + ", " + vehiculo.getPlaca()));
		}
		return parametros;
	}

	@Override
	public Byte[] firmarXml(Document documentXml) {
		// TODO: implement
		return null;
	}

	@Override
	public GuiaRemision buscarGreOriginal(PkGuia pkGruiremision) {
		// TODO: implement
		return null;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

}
