-- public.dataexcel definition

-- Drop table

-- DROP TABLE public.dataexcel;

CREATE TABLE public.dataexcel (
	id int8 NOT NULL,
	area_administrativa varchar(255) NULL,
	cantidad_fibras varchar(255) NULL,
	codigo_tramo_cable_optico varchar(255) NULL,
	id_tramo_cable_optico varchar(255) NULL,
	longitud_estimada_total varchar(255) NULL,
	ot_estado_actual varchar(255) NULL,
	ot_fecha_implantacion varchar(255) NULL,
	orden_trabajo varchar(255) NULL,
	propiedad varchar(255) NULL,
	propietario varchar(255) NULL,
	ruta varchar(255) NULL,
	situacion varchar(255) NULL,
	trfo_ot_actual varchar(255) NULL,
	trfo_ot_original varchar(255) NULL,
	usuario varchar(255) NULL,
	CONSTRAINT dataexcel_pkey PRIMARY KEY (id)
);

-- public.datacsv definition

-- Drop table

-- DROP TABLE public.datacsv;

CREATE TABLE public.datacsv (
	id int8 NOT NULL,
	"_16_liberado_a_ventas" varchar(255) NULL,
	agencia varchar(255) NULL,
	altura varchar(255) NULL,
	ano_cumplimiento varchar(255) NULL,
	cantidad_hp varchar(255) NULL,
	direccion varchar(255) NULL,
	empresa_adjudicada varchar(255) NULL,
	empresa_colaboradora varchar(255) NULL,
	estado_asignacion_recurso varchar(255) NULL,
	estado_creacion_direcciones varchar(255) NULL,
	estado_cruzado_fisica varchar(255) NULL,
	estado_cruzado_logica varchar(255) NULL,
	estado_stb varchar(255) NULL,
	hp_cargadas_osp varchar(255) NULL,
	identificador varchar(255) NULL,
	nombre_pm varchar(255) NULL,
	nombre_proyecto varchar(255) NULL,
	numero_cubicacion varchar(255) NULL,
	oecc varchar(255) NULL,
	oecc_actividad varchar(255) NULL,
	oecc_comuna varchar(255) NULL,
	oecc_cubicacion varchar(255) NULL,
	oecc_pep2 varchar(255) NULL,
	oecc_resp_actividad varchar(255) NULL,
	oeci varchar(255) NULL,
	oficina_central_fttx varchar(255) NULL,
	osp_asi varchar(255) NULL,
	osp_cap_fo varchar(255) NULL,
	osp_coberturas varchar(255) NULL,
	osp_n_equipos varchar(255) NULL,
	osp_ocu varchar(255) NULL,
	pep2 varchar(255) NULL,
	region varchar(255) NULL,
	related_oecc varchar(255) NULL,
	related_oeci varchar(255) NULL,
	semana varchar(255) NULL,
	semana_real varchar(255) NULL,
	smell varchar(255) NULL,
	target varchar(255) NULL,
	target_real varchar(255) NULL,
	tipo varchar(255) NULL,
	tipo_caja varchar(255) NULL,
	tipo_proyecto varchar(255) NULL,
	CONSTRAINT datacsv_pkey PRIMARY KEY (id)
);