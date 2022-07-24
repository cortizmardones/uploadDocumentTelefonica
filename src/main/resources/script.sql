
DROP TABLE telefonica.public.data1;

TRUNCATE telefonica.public.data1; 


CREATE TABLE public.data1 (
	id int4 NOT NULL,
	"area_administrativa" varchar NULL,
	situacion varchar NULL,
	"id_tramo_cable_optico" varchar NULL,
	"codigo_tramo_cable_optico" varchar NULL,
	"cantidad_fibras" varchar NULL,
	"longitud_estimada_total" varchar NULL,
	propiedad varchar NULL,
	propietario varchar NULL,
	"trfo_ot_actual" varchar NULL,
	"trfo_ot_original" varchar NULL,
	"orden_trabajo" varchar NULL,
	"ot_fecha_implantacion" varchar NULL,
	"ot_estado_actual" varchar NULL,
	ruta varchar NULL,
	usuario varchar NULL
);