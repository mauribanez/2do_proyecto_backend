-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-12-01 05:11:11.714

-- tables
-- Table: Category
CREATE TABLE Category (
    Category_id serial  NOT NULL,
    nameCategory varchar(500)  NOT NULL,
    CONSTRAINT Category_pk PRIMARY KEY (Category_id)
);

-- Table: TypeCocktail
CREATE TABLE TypeCocktail (
    typeCocktail_id serial  NOT NULL,
    nameType varchar(50)  NOT NULL,
    CONSTRAINT TypeCocktail_pk PRIMARY KEY (typeCocktail_id)
);

-- Table: Ingredients
CREATE TABLE Ingredients (
    ingrediente_id serial  NOT NULL,
    nombre varchar(255)  NOT NULL,
    cantidad varchar(100)  NOT NULL,
    CONSTRAINT Ingredients_pk PRIMARY KEY (ingrediente_id)
);


-- Table: Cocktails
CREATE TABLE Cocktails (
    cocktail_id serial  NOT NULL,
    name_cocktail varchar(255)  NOT NULL,
    preparation varchar(5000)  NOT NULL,
    tipoCocktail_tipoCocktail_id serial  NOT NULL,
    Type_Category_typeCategory_id serial  NOT NULL,
    CONSTRAINT Cocktails_pk PRIMARY KEY (cocktail_id)
);


-- Table: CocktailIngredients
CREATE TABLE CocktailIngredients (
    cocktail_ingredient_id serial  NOT NULL,
    Cocktails_cocktail_id serial  NOT NULL,
    Ingredients_ingrediente_id serial  NOT NULL,
    CONSTRAINT CocktailIngredients_pk PRIMARY KEY (cocktail_ingredient_id)
);


-- Table: Users
CREATE TABLE Users (
    user_id serial  NOT NULL,
    nombre varchar(255)  NOT NULL,
    correo_electronico varchar(255)  NOT NULL,
    contrasena varchar(255)  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (user_id)
);

-- Table: ChatConversations
CREATE TABLE ChatConversations (
    conversacion_id serial  NOT NULL,
    mensaje varchar(5000)  NOT NULL,
    respuesta_gpt varchar(5000)  NOT NULL,
    fecha timestamp  NOT NULL DEFAULT current_timestamp,
    Users_user_id serial  NOT NULL,
    CONSTRAINT ChatConversations_pk PRIMARY KEY (conversacion_id)
);

-- Table: ChatHistory
CREATE TABLE ChatHistory (
    chat_history_id serial  NOT NULL,
    consulta varchar(5000)  NOT NULL,
    respuesta_gpt varchar(5000)  NOT NULL,
    fecha timestamp  NOT NULL DEFAULT current_timestamp,
    Users_user_id serial  NOT NULL,
    CONSTRAINT ChatHistory_pk PRIMARY KEY (chat_history_id)
);


-- Table: UserCocktails
CREATE TABLE UserCocktails (
    user_cocktail_id serial  NOT NULL,
    Cocktails_cocktail_id serial  NOT NULL,
    Users_user_id serial  NOT NULL,
    CONSTRAINT UserCocktails_pk PRIMARY KEY (user_cocktail_id)
);


-- foreign keys
-- Restricción de clave externa en la tabla ChatConversations que referencia la tabla Users
ALTER TABLE ChatConversations
ADD CONSTRAINT ChatConversations_Users FOREIGN KEY (Users_user_id)
REFERENCES Users (user_id);

-- Restricción de clave externa en la tabla ChatHistory que referencia la tabla Users
ALTER TABLE ChatHistory
ADD CONSTRAINT ChatHistory_Users FOREIGN KEY (Users_user_id)
REFERENCES Users (user_id);

-- Restricción de clave externa en la tabla CocktailIngredients que referencia la tabla Cocktails
ALTER TABLE CocktailIngredients
ADD CONSTRAINT CocktailIngredients_Cocktails FOREIGN KEY (Cocktails_cocktail_id)
REFERENCES Cocktails (cocktail_id);

-- Restricción de clave externa en la tabla CocktailIngredients que referencia la tabla Ingredients
ALTER TABLE CocktailIngredients
ADD CONSTRAINT CocktailIngredients_Ingredients FOREIGN KEY (Ingredients_ingrediente_id)
REFERENCES Ingredients (ingrediente_id);

-- Restricción de clave externa en la tabla Cocktails que referencia la tabla Category
ALTER TABLE Cocktails
ADD CONSTRAINT Cocktails_Type_Category FOREIGN KEY (Type_Category_typeCategory_id)
REFERENCES Category (Category_id);

-- Restricción de clave externa en la tabla Cocktails que referencia la tabla TypeCocktail
ALTER TABLE Cocktails
ADD CONSTRAINT Cocktails_tipoCocktail FOREIGN KEY (tipoCocktail_tipoCocktail_id)
REFERENCES TypeCocktail (typeCocktail_id);

-- Restricción de clave externa en la tabla UserCocktails que referencia la tabla Cocktails
ALTER TABLE UserCocktails
ADD CONSTRAINT UserCocktails_Cocktails FOREIGN KEY (Cocktails_cocktail_id)
REFERENCES Cocktails (cocktail_id);

-- Restricción de clave externa en la tabla UserCocktails que referencia la tabla Users
ALTER TABLE UserCocktails
ADD CONSTRAINT UserCocktails_Users FOREIGN KEY (Users_user_id)
REFERENCES Users (user_id);
-- End of file.




