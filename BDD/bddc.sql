-- Tabla de Cocteles (Cocktails)
CREATE TABLE Cocktails (
    coctel_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255),
    alcoholic VARCHAR(50),
    glass VARCHAR(50),
    instrucciones TEXT,
    imagen_url VARCHAR(255),
    FOREIGN KEY (coctel_id) REFERENCES CocktailIngredients(coctel_id)
);

-- Tabla de Ingredientes (Ingredients)
CREATE TABLE Ingredients (
    ingrediente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Tabla de Relación Coctel-Ingredientes (CocktailIngredients)
CREATE TABLE CocktailIngredients (
    cocktail_ingredient_id INT AUTO_INCREMENT PRIMARY KEY,
    coctel_id INT,
    ingrediente_id INT,
    cantidad VARCHAR(50),
    FOREIGN KEY (coctel_id) REFERENCES Cocktails(coctel_id),
    FOREIGN KEY (ingrediente_id) REFERENCES Ingredients(ingrediente_id)
);

-- Tabla de Usuarios (Users)
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- Tabla de Cocteles de Usuarios (UserCocktails)
CREATE TABLE UserCocktails (
    user_cocktail_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    coctel_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (coctel_id) REFERENCES Cocktails(coctel_id)
);

-- Tabla de Conversaciones de ChatGPT (ChatConversations)
CREATE TABLE ChatConversations (
    conversacion_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    mensaje TEXT,
    respuesta_gpt TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Tabla de Historial de Conversaciones con ChatGPT (ChatHistory)
CREATE TABLE ChatHistory (
    chat_history_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    consulta TEXT,
    respuesta_gpt TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);




