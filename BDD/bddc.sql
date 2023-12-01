-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-12-01 05:11:11.714

-- tables
-- Table: Category
CREATE TABLE Category (
    Category_id serial  NOT NULL,
    nameCategory varchar(500)  NOT NULL,
    CONSTRAINT Category_pk PRIMARY KEY (Category_id)
);

-- Table: ChatConversations
CREATE TABLE ChatConversations (
    conversacion_id serial  NOT NULL AUTO_INCREMENT,
    mensaje varchar(5000)  NOT NULL,
    respuesta_gpt varchar(5000)  NOT NULL,
    fecha timestamp  NOT NULL DEFAULT current_timestamp,
    Users_user_id serial  NOT NULL,
    CONSTRAINT ChatConversations_pk PRIMARY KEY (conversacion_id)
);

-- Table: ChatHistory
CREATE TABLE ChatHistory (
    chat_history_id serial  NOT NULL AUTO_INCREMENT,
    consulta varchar(5000)  NOT NULL,
    respuesta_gpt varchar(5000)  NOT NULL,
    fecha timestamp  NOT NULL DEFAULT current_timestamp,
    Users_user_id serial  NOT NULL,
    CONSTRAINT ChatHistory_pk PRIMARY KEY (chat_history_id)
);

-- Table: CocktailIngredients
CREATE TABLE CocktailIngredients (
    cocktail_ingredient_id serial  NOT NULL AUTO_INCREMENT,
    Cocktails_cocktail_id serial  NOT NULL,
    Ingredients_ingrediente_id serial  NOT NULL,
    CONSTRAINT CocktailIngredients_pk PRIMARY KEY (cocktail_ingredient_id)
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

-- Table: Ingredients
CREATE TABLE Ingredients (
    ingrediente_id serial  NOT NULL AUTO_INCREMENT,
    nombre varchar(255)  NOT NULL,
    cantidad varchar(100)  NOT NULL,
    CONSTRAINT Ingredients_pk PRIMARY KEY (ingrediente_id)
);

-- Table: TypeCocktail
CREATE TABLE TypeCocktail (
    typeCocktail_id serial  NOT NULL,
    nameType varchar(50)  NOT NULL,
    CONSTRAINT TypeCocktail_pk PRIMARY KEY (typeCocktail_id)
);

-- Table: UserCocktails
CREATE TABLE UserCocktails (
    user_cocktail_id serial  NOT NULL AUTO_INCREMENT,
    Cocktails_cocktail_id serial  NOT NULL,
    Users_user_id serial  NOT NULL,
    CONSTRAINT UserCocktails_pk PRIMARY KEY (user_cocktail_id)
);

-- Table: Users
CREATE TABLE Users (
    user_id serial  NOT NULL AUTO_INCREMENT,
    nombre varchar(255)  NOT NULL,
    correo_electronico varchar(255)  NOT NULL,
    contrasena varchar(255)  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: ChatConversations_Users (table: ChatConversations)
ALTER TABLE ChatConversations ADD CONSTRAINT ChatConversations_Users FOREIGN KEY ChatConversations_Users (Users_user_id)
    REFERENCES Users (user_id);

-- Reference: ChatHistory_Users (table: ChatHistory)
ALTER TABLE ChatHistory ADD CONSTRAINT ChatHistory_Users FOREIGN KEY ChatHistory_Users (Users_user_id)
    REFERENCES Users (user_id);

-- Reference: CocktailIngredients_Cocktails (table: CocktailIngredients)
ALTER TABLE CocktailIngredients ADD CONSTRAINT CocktailIngredients_Cocktails FOREIGN KEY CocktailIngredients_Cocktails (Cocktails_cocktail_id)
    REFERENCES Cocktails (cocktail_id);

-- Reference: CocktailIngredients_Ingredients (table: CocktailIngredients)
ALTER TABLE CocktailIngredients ADD CONSTRAINT CocktailIngredients_Ingredients FOREIGN KEY CocktailIngredients_Ingredients (Ingredients_ingrediente_id)
    REFERENCES Ingredients (ingrediente_id);

-- Reference: Cocktails_Type_Category (table: Cocktails)
ALTER TABLE Cocktails ADD CONSTRAINT Cocktails_Type_Category FOREIGN KEY Cocktails_Type_Category (Type_Category_typeCategory_id)
    REFERENCES Category (Category_id);

-- Reference: Cocktails_tipoCocktail (table: Cocktails)
ALTER TABLE Cocktails ADD CONSTRAINT Cocktails_tipoCocktail FOREIGN KEY Cocktails_tipoCocktail (tipoCocktail_tipoCocktail_id)
    REFERENCES TypeCocktail (typeCocktail_id);

-- Reference: UserCocktails_Cocktails (table: UserCocktails)
ALTER TABLE UserCocktails ADD CONSTRAINT UserCocktails_Cocktails FOREIGN KEY UserCocktails_Cocktails (Cocktails_cocktail_id)
    REFERENCES Cocktails (cocktail_id);

-- Reference: UserCocktails_Users (table: UserCocktails)
ALTER TABLE UserCocktails ADD CONSTRAINT UserCocktails_Users FOREIGN KEY UserCocktails_Users (Users_user_id)
    REFERENCES Users (user_id);

-- End of file.




