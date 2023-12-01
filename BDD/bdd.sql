-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-13 01:13:24.907

-- Table: Coctel_creado
CREATE TABLE Coctel_creado (
    id serial  NOT NULL,
    Categoria_id int  NOT NULL,
    Usuario_id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    descripcion varchar(250)  NOT NULL,
    ingredientes varchar(250)  NOT NULL,
    instrucciones varchar(250)  NOT NULL,
    notas varchar(150)  NOT NULL,
    CONSTRAINT Coctel_creado_pk PRIMARY KEY (id)
);

-- Table: Coctel_solicitud
CREATE TABLE Coctel_solicitud (
    id serial  NOT NULL,
    licor1 varchar(50)  NOT NULL,
    licor2 varchar(50)  NULL,
    licor3 varchar(50)  NULL,
    licor4 varchar(50)  NULL,
    bebida1 varchar(50)  NOT NULL,
    bebida2 varchar(50)  NULL,
    bebida3 varchar(50)  NULL,
    bebida4 varchar(50)  NULL,
    extras varchar(150)  NULL,
    comentarios varchar(250)  NULL,
    CONSTRAINT Coctel_solicitud_pk PRIMARY KEY (id)
);

-- Table: Cocteles
CREATE TABLE Cocteles (
    id serial  NOT NULL,
    Categoria_id int  NOT NULL,
    Usuario_id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    descripcion varchar(250)  NOT NULL,
    ingredientes varchar(250)  NOT NULL,
    instrucciones varchar(250)  NOT NULL,
    CONSTRAINT Cocteles_pk PRIMARY KEY (id)
);

-- Table: Historial_cocteles_generado
CREATE TABLE Historial_cocteles_generado (
    id serial  NOT NULL,
    Coctel_solicitud_id int  NOT NULL,
    Categoria_id int  NOT NULL,
    Usuario_id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    descripcion varchar(250)  NOT NULL,
    ingredientes varchar(250)  NOT NULL,
    instrucciones varchar(500)  NOT NULL,
    fecha int  NOT NULL,
    CONSTRAINT Historial_cocteles_generado_pk PRIMARY KEY (id)
);

-- Table: Tipo_Usuario
CREATE TABLE Tipo_Usuario (
    id int  NOT NULL,
    tipo varchar(100)  NOT NULL,
    CONSTRAINT Tipo_Usuario_pk PRIMARY KEY (id)
);

-- Table: Usuario
CREATE TABLE Usuario (
    id serial  NOT NULL,
    Tipo_Usuario_id int  NOT NULL,
    username varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    gmail varchar(70)  NOT NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Coctel_creado_Categoria (table: Coctel_creado)
ALTER TABLE Coctel_creado ADD CONSTRAINT Coctel_creado_Categoria
    FOREIGN KEY (Categoria_id)
    REFERENCES Categoria (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Coctel_creado_Usuario (table: Coctel_creado)
ALTER TABLE Coctel_creado ADD CONSTRAINT Coctel_creado_Usuario
    FOREIGN KEY (Usuario_id)
    REFERENCES Usuario (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Cocteles_Categoria (table: Cocteles)
ALTER TABLE Cocteles ADD CONSTRAINT Cocteles_Categoria
    FOREIGN KEY (Categoria_id)
    REFERENCES Categoria (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Cocteles_Usuario (table: Cocteles)
ALTER TABLE Cocteles ADD CONSTRAINT Cocteles_Usuario
    FOREIGN KEY (Usuario_id)
    REFERENCES Usuario (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Historial_cocteles_generado_Categoria (table: Historial_cocteles_generado)
ALTER TABLE Historial_cocteles_generado ADD CONSTRAINT Historial_cocteles_generado_Categoria
    FOREIGN KEY (Categoria_id)
    REFERENCES Categoria (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Historial_cocteles_generado_Coctel_solicitud (table: Historial_cocteles_generado)
ALTER TABLE Historial_cocteles_generado ADD CONSTRAINT Historial_cocteles_generado_Coctel_solicitud
    FOREIGN KEY (Coctel_solicitud_id)
    REFERENCES Coctel_solicitud (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Historial_cocteles_generado_Usuario (table: Historial_cocteles_generado)
ALTER TABLE Historial_cocteles_generado ADD CONSTRAINT Historial_cocteles_generado_Usuario
    FOREIGN KEY (Usuario_id)
    REFERENCES Usuario (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Usuario_Tipo_Usuario (table: Usuario)
ALTER TABLE Usuario ADD CONSTRAINT Usuario_Tipo_Usuario
    FOREIGN KEY (Tipo_Usuario_id)
    REFERENCES Tipo_Usuario (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.