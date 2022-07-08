package com.sofka.bingo_game.controller;

import com.sofka.bingo_game.domain.BingoNumber;
import com.sofka.bingo_game.domain.Game;
import com.sofka.bingo_game.domain.PlayersLobby;
import com.sofka.bingo_game.gameLogic.BingoCard;
import com.sofka.bingo_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * Controller for the Game, players
 *
 * @author Jonathan Daniel Pinilla Forero
 * @version 1.0.0 2022-07-04
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/game")
public class gameController {

    /**
     * Injects the GameService
     */
    @Autowired
    private GameService gameService;


    /**
     * Gets the list of games available
     * @return List of games
     */
    @GetMapping(path = "/")
    public List<Game> getGames(){
        return gameService.getGames();
    }

    /**
     * Creates new game
     * @param game to create
     * @return game created
     */
    @PostMapping(path = "/")
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
    }

    /**
     * Search game by its id
     * @return the game found
     */
    @GetMapping(path = "/{id}")
    public Game getOneGame(@PathVariable Integer id){
        return gameService.getOneGame(id);
    }

    /**
     * Adds a player to a game lobby
     * @param playersLobby to add
     * @return playersLobby added
     */
    @PostMapping(path = "/tolobby")
    public PlayersLobby addPlayer(@RequestBody PlayersLobby playersLobby){
        return gameService.addPlayerLobby(playersLobby);
    }

    /**
     * Updates a game
     * @param id of the game to update
     * @param game information to update
     * @return game updated
     */
    @PutMapping(path = "/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game game){
        return gameService.updateGame(id, game);
    }

    /**
     * Deletes a game
     * @param id of the game to delete
     */
    @DeleteMapping(path = "/{id}")
    public void deleteGame(@PathVariable Integer id){
        gameService.deleteGame(id);
    }

    /**
     * Deletes a Player from the game lobby
     * @param id of the player to delete
     */
    @DeleteMapping(path = "player/{id}")
    public void deletePlayer(@PathVariable String id){
        gameService.deletePlayersLobby(id);
    }

    /**
     * Clear the playersLobby table
     */
    @DeleteMapping(path = "/players")
    public void clearAllPlayers(){
        gameService.deleteAllPlayers();
    }

    /**
     * Gets all the bingo numbers
     * @return List of BingoNumbers
     */
    @GetMapping(path = "/bingonumbers")
    public List<BingoNumber> getBingoNumbers(){
        return gameService.getBingoNumbers();
    }

    /**
     * Add a bingo number to the DB
     * @param bingoNumber to store
     * @return Bingo number stored
     */
    @PostMapping(path = "/bingonumbers")
    public BingoNumber addBingoNumber(@RequestBody BingoNumber bingoNumber){
        return gameService.newBingoNumber(bingoNumber);
    }

    /**
     * Clear all the bingo numbers
     */
    @DeleteMapping(path = "/bingonumbers")
    public void deleteBingoNumbers(){
        gameService.deleteBingoNumbers();
    }
    //End of CRUD ------------------------------------------------------------------------------------------------------

    // Mapping for BingoCard and game functionalities-------------------------------------------------------------------

    /**
     * Creates a bingo card
     * @return the bingo card created
     */
    @GetMapping(path = "/bingocard")
    public BingoCard getBingoCard(){
        return new BingoCard();
    }

    /**
     * Generates a random number
     * @return numbre for a bingo ball
     */
    @GetMapping(path = "/bingoball")
    public int getBingoBall(){
        Random random = new Random();
        return random.nextInt((75 - 1) + 1) + 1;
    }
}
