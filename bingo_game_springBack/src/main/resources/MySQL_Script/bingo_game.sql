/**
Creates bingo game database (use it only on the first run), and then select the bingo database
to run the follwing instructions
**/
CREATE DATABASE bingoGame;
USE bingoGame;

CREATE TABLE game
(
	game_id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
	is_started BOOLEAN NOT NULL,
	ended BOOLEAN NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE players_lobby
(
	player_id VARCHAR(100) PRIMARY KEY NOT NULL,
    player_name VARCHAR(100) NOT NULL,
    player_game INTEGER NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE bingo_numbers
(
	ball_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ball_number INT NOT NULL 
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE players_lobby ADD CONSTRAINT fk_player_game
FOREIGN KEY (player_game) REFERENCES game(game_id)
ON UPDATE CASCADE ON DELETE RESTRICT;