package com.sofka.bingo_game.service.interfaces;

import com.sofka.bingo_game.domain.BingoNumber;
import com.sofka.bingo_game.domain.Game;
import com.sofka.bingo_game.domain.PlayersLobby;

import java.util.List;

/**
 * Interface for the game service
 *
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @version 1.0.0 2022-07-04
 * @since 1.0.0
 */
public interface Igame {

    /**
     * Gets the list of games available
     * @return game list
     */
    public List<Game> getGames();

    /**
     * Search game by its id
     * @return the game found
     */
    public Game getOneGame(Integer id);

    /**
     * Saves the Game
     * @return Game saved
     */
    public Game save(Game game);

    /**
     * Gets all the players in a game
     * @return PlayersLobby list
     */
    public List<PlayersLobby> getPlayers();

    /**
     * Creates a new game
     * @return game created
     */
    public Game createGame(Game game);

    /**
     * Creates a new players lobby (contains only one player linked to a game)
     * @return PlayersLobby created
     */
    public PlayersLobby addPlayerLobby(PlayersLobby playersLobby);

    /**
     * Updates a game
     * @return Game updated
     */
    public Game updateGame(Integer id, Game game);

    /**
     * Deletes a game
     * @return Game deleted
     */
    public void deleteGame(Integer id);

    /**
     * Deletes all PlayersLobby
     */
    public void deletePlayersLobby(String id);

    /**
     * Clean the playersLobby table to create a new game
     */
    public void deleteAllPlayers();

    /**
     * Deletes all games
     */
    public void deleteAllGames(List<Game> games);

    /**
     * Creates a new Bingo number
     * @param bingoNumber the number to add
     * @return Bingo number created
     */
    public BingoNumber newBingoNumber(BingoNumber bingoNumber);

    /**
     * Find all the bingo numbers
     * @return list of BingoNumbers
     */
    public List<BingoNumber> getBingoNumbers();

    /**
     * Deletes all the bingo numbers
     */
    public void deleteBingoNumbers();
}
