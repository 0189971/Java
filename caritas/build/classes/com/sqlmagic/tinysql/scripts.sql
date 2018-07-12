create table ubicacion ( id_ubicacion int, nombre_ubicacion char(10), descripcion_ubicacion char(100) ); 

create table equipo ( id_equipo int, nombre_equipo char(100) );

create table prioridad ( id_prioridad int, nombre_prioridad char(50) );

create table via ( id_via int, nombre_via char(50) );

create table tipo_evento ( id_tipo_evento int, nombre_tipo_evento char(100), nomenclatura_tipo_evento char(10) );

create table evento ( id_evento int, hora char(50), id_ubicacion int, id_equipo int, descripcion char(240), id_prioridad int, id_via int, id_tipo_evento int );

create table alarma ( id_alarma int, id_tipo_evento int, reconocimiento char(5), hora char(50), id_ubicacion int, id_equipo int, descripcion char(240) );

insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  1, "GPA", "Garage Pantitlan" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  2, "PAN", "Pantitlan" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  3, "PUE", "Puebla" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  4, "DEP", "Ciudad Deportiva" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  5, "VEL", "Velodromo" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  6, "MIU", "Mixiuhca" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  7, "JAM", "Jamaica" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  8, "CHB", "Chabacano" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values (  9, "LCA", "Lazaro Cardenas" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 10, "CME", "Centro Medico" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 11, "CHI", "Chilpancingo" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 12, "ESC", "Escandon" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 13, "PAT", "Patriotismo" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 14, "TCY", "Tacubaya" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 15, "ZNC", "Zona C" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 16, "ZND", "Zona D" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 17, "ZNE", "Zona E" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 18, "ZNF", "Zona F" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 19, "ZNG", "Zona G" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 20, "ZNH", "Zona H" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 21, "LIN", "Linea" );
insert into ubicacion ( id_ubicacion, nombre_ubicacion, descripcion_ubicacion ) values ( 22, "PCC", "Puesto Central de Control" );

insert into via ( id_via, nombre_via ) values ( 1, "Via 1" );
insert into via ( id_via, nombre_via ) values ( 2, "Via 2" );
insert into via ( id_via, nombre_via ) values ( 3, "Auxiliares" );

insert into prioridad ( id_prioridad, nombre_prioridad ) values ( 1, "Baja" );
insert into prioridad ( id_prioridad, nombre_prioridad ) values ( 2, "Media baja" );
insert into prioridad ( id_prioridad, nombre_prioridad ) values ( 3, "Media alta" );
insert into prioridad ( id_prioridad, nombre_prioridad ) values ( 4, "Alta" );
insert into prioridad ( id_prioridad, nombre_prioridad ) values ( 5, "Alarmas manuales" );

insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  1, "Aguja en modo manual",              "AGU" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  2, "Alarma Sirena",                     "SIR" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  3, "Corte de Urgencia",                 "CU" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  4, "CTP Discordante",                   "CTP" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  5, "Discordancia",                      "DIS" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  6, "DNB",                               "DNB" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  7, "Franqueamiento",                    "FRANQ" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  8, "Incidente Linea",                   "IL" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values (  9, "Mando Local de Equipo de traccion", "ML" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values ( 10, "RM",                                "RM" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values ( 11, "RMFS",                              "RMFS" );
insert into tipo_evento ( id_tipo_evento, nombre_tipo_evento, nomenclatura_tipo_evento ) values ( 12, "Teletransmision",                   "TT" );

insert into equipo ( id_equipo, nombre_equipo ) values (  1, "Bateria conmutador" );
insert into equipo ( id_equipo, nombre_equipo ) values (  2, "Bateria de senalizacion" );
insert into equipo ( id_equipo, nombre_equipo ) values (  3, "Bateria de sonorizacion" );
insert into equipo ( id_equipo, nombre_equipo ) values (  4, "Bateria de telefono" );
insert into equipo ( id_equipo, nombre_equipo ) values (  5, "Cabina P" );
insert into equipo ( id_equipo, nombre_equipo ) values (  6, "Carcamo" );
insert into equipo ( id_equipo, nombre_equipo ) values (  7, "Circ. alumbrado" );
insert into equipo ( id_equipo, nombre_equipo ) values (  8, "Cisterna" );
insert into equipo ( id_equipo, nombre_equipo ) values (  9, "Equipo de PDC" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 10, "Equipos de PDC/TRC" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 11, "Equipo traccion" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 12, "Equipo trafico" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 13, "Escalera mecanica" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 14, "Gestion terminal" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 15, "Interruptor general" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 16, "Local conmutador" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 17, "Local de ventilacion" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 18, "Local tecnico-puerta abierta" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 19, "Local tecnico-temperatura peligrosa" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 20, "Programa explotacion" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 21, "Puerta SR" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 22, "Puerta subestacion" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 23, "Regulacion" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 24, "Seguimiento" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 25, "Servicio provisional" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 26, "Sistemas" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 27, "Taquillas" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 28, "Teletransmision" );
insert into equipo ( id_equipo, nombre_equipo ) values ( 29, "Ventilacion mayor" );