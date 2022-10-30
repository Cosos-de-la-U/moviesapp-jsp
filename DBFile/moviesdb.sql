create table usuarios
(
    carnet VARCHAR(20) primary key not null,
    nom_usuario CHAR(30) not null,
    ape_usuario CHAR(30) not null,
    tipo CHAR(30),
    telcasa CHAR(9),
    celular CHAR(9),
    email CHAR(100),
    estado CHAR(20),
    clave CHAR(50) not null,
    acessosistemas INTEGER,
    esadministrador INTEGER
);

create table peliculas
(
    idpelicula SERIAL primary key not null ,
    nombre VARCHAR(200),
    nomb_ingles VARCHAR(200),
    yearp INTEGER,
    duracion INTEGER
);

create table fotos
(
    idfoto SERIAL primary key not null,
    idpelicula INTEGER references peliculas(idpelicula),
    foto VARCHAR(254),
    primera VARCHAR(1)
);

create table categoria
(
    idcategoria SERIAL primary key not null,
    categoria VARCHAR(200)
);

create table peliculavista
(
    idpeliculavista SERIAL primary key not null,
    idpelicula INTEGER references peliculas(idpelicula),
    carnet VARCHAR(20) references usuarios(carnet),
    comentario TEXT,
    calificacion INT
);

create table categoriapeliculas
(
    idcatpelicula SERIAL primary key not null,
    idcategoria INT references categoria(idcategoria),
    idpelicula INT references peliculas(idpelicula)
);

insert into usuarios (carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador)
values
    ('2018PR603', 'Raul', 'Penate', 'uno', '22222222', '22222222', 'raulpenate@gmail.com', 'activo', '1234', '0', '0'),
    ('2019AC600', 'Carlos', 'Hernandez', 'uno', '22222222', '22222222', 'carloshernandez@gmail.com', 'activo', '1234', '0', '1'),
    ('2018KB600', 'Kerim', 'Borja', 'uno', '22222222', '22222222', 'kerimborja@gmail.com', 'activo', '1234', '2', '1');

SELECT * FROM usuarios;
