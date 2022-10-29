CREATE TABLE "usuarios" (
  "carnet" VARCHAR(20) PRIMARY KEY NOT NULL,
  "nom_usuario" CHAR(30) NOT NULL,
  "ape_usuario" CHAR(30) NOT NULL,
  "tipo" CHAR(30),
  "telcasa" CHAR(9),
  "celular" CHAR(9),
  "email" CHAR(100),
  "estado" CHAR(20),
  "clave" CHAR(50) NOT NULL,
  "accessosistemas" INTEGER,
  "esadministardor" INTEGER
);

CREATE TABLE "peliculas" (
  "idpelicula" SERIAL PRIMARY KEY NOT NULL,
  "nombre" VARCHAR(200),
  "nomb_ingles" VARCHAR(200),
  "yearp" INTEGER,
  "duracion" INTEGER
);

CREATE TABLE "fotos" (
  "idfoto" SERIAL PRIMARY KEY NOT NULL,
  "idpelicula" INTEGER,
  "foto" VARCHAR(254),
  "primera" VARCHAR(1)
);

CREATE TABLE "categoria" (
  "idcategoria" SERIAL PRIMARY KEY NOT NULL,
  "categoria" VARCHAR(200)
);

CREATE TABLE "peliculavista" (
  "idpeliculavista" SERIAL PRIMARY KEY NOT NULL,
  "idpelicula" INTEGER,
  "carnet" VARCHAR(20),
  "comentario" TEXT,
  "calificacion" INT
);

CREATE TABLE "categoriapeliculas" (
  "idcatpelicula" SERIAL PRIMARY KEY NOT NULL,
  "idcategoria" INT,
  "idpelicula" INT
);

ALTER TABLE "fotos" ADD FOREIGN KEY ("idpelicula") REFERENCES "peliculas" ("idpelicula");

ALTER TABLE "peliculavista" ADD FOREIGN KEY ("idpelicula") REFERENCES "peliculas" ("idpelicula");

ALTER TABLE "peliculavista" ADD FOREIGN KEY ("carnet") REFERENCES "usuarios" ("carnet");

ALTER TABLE "categoriapeliculas" ADD FOREIGN KEY ("idcategoria") REFERENCES "categoria" ("idcategoria");

ALTER TABLE "categoriapeliculas" ADD FOREIGN KEY ("idpelicula") REFERENCES "peliculas" ("idpelicula");
