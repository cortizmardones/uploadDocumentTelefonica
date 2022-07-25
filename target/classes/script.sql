-- public.data1 definition

-- Drop table

-- DROP TABLE public.data1;

CREATE TABLE public.data1 (
	id int4 NOT NULL,
	area_administrativa varchar NULL,
	situacion varchar NULL,
	id_tramo_cable_optico varchar NULL,
	codigo_tramo_cable_optico varchar NULL,
	cantidad_fibras varchar NULL,
	longitud_estimada_total varchar NULL,
	propiedad varchar NULL,
	propietario varchar NULL,
	trfo_ot_actual varchar NULL,
	trfo_ot_original varchar NULL,
	orden_trabajo varchar NULL,
	ot_fecha_implantacion varchar NULL,
	ot_estado_actual varchar NULL,
	ruta varchar NULL,
	usuario varchar NULL
);

-- public.data2 definition

-- Drop table

-- DROP TABLE public.data2;

CREATE TABLE public.data2 (
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
	CONSTRAINT data2_pkey PRIMARY KEY (id)
);