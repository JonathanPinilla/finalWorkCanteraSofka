package com.sofka.bingo_game.service;

import com.sofka.bingo_game.domain.BingoNumber;
import com.sofka.bingo_game.domain.Game;
import com.sofka.bingo_game.domain.PlayersLobby;
import com.sofka.bingo_game.repositories.BingoNumberRepository;
import com.sofka.bingo_game.repositories.GameRepository;
import com.sofka.bingo_game.repositories.PlayersLobbyRepository;
import com.sofka.bingo_game.service.interfaces.Igame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService implements Igame {

    /**
     * Injects the GameRepository
     */
    @Autowired
    private GameRepository gameRepository;

    /**
     * Injects the PlayersLobbyRepository
     */
    @Autowired
    private PlayersLobbyRepository playersLobbyRepository;

    /**
     * Injects the BingoNumberRepository
     */
    @Autowired
    private BingoNumberRepository bingoNumberRepository;

    /**
     * Gets the list of games available
     *
     * @return game list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Game> getGames() {
        return (List<Game>) gameRepository.findAll();
    }

    /**
     * Saves the Game
     *
     * @return Game saved
     */
    @Override
    @Transactional
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    /**
     * Gets all the players in a game
     *
     * @return PlayersLobby list
     */
    @Override
    @Transactional(readOnly = true)
    public List<PlayersLobby> getPlayers() {
        return (List<PlayersLobby>) playersLobbyRepository.findAll();
    }

    /**
     * Creates a new game
     *
     * @return game created
     */
    @Override
    @Transactional
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     * Creates a new players lobby (contains only one player linked to a game)
     *
     * @return PlayersLobby created
     */
    @Override
    @Transactional
    public PlayersLobby addPlayerLobby(PlayersLobby playersLobby) {
        return playersLobbyRepository.save(playersLobby);
    }

    /**
     * Search game by its id
     * @return the game found
     */
    @Override
    @Transactional(readOnly = true)
    public Game getOneGame(Integer id){
        return gameRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    /**
     * Updates a game
     *
     * @return Game updated
     */
    @Override
    @Transactional
    public Game updateGame(Integer id, Game game) {
        game.setId(id);
        return gameRepository.save(game);
    }

    /**
     * Deletes a game
     *
     * @return Game deleted
     */
    @Override
    @Transactional
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    /**
     * Deletes all PlayersLobby
     */
    @Override
    @Transactional
    public void deletePlayersLobby(String id) {
        playersLobbyRepository.deleteById(id);
    }

    /**
     * Deletes all players
     */
    @Override
    @Transactional
    public void deleteAllPlayers(){
        playersLobbyRepository.deleteAll();
    }

    /**
     * Deletes all games
     */
    public void deleteAllGames(List<Game> games){
        gameRepository.deleteAll(games);
    }

    /**
     * Creates a new Bingo number
     *
     * @param bingoNumber the number to add
     * @return Bingo number created
     */
    @Override
    @Transactional
    public BingoNumber newBingoNumber(BingoNumber bingoNumber) {
        return bingoNumberRepository.save(bingoNumber);
    }

    /**
     * Find all the bingo numbers
     *
     * @return list of BingoNumbers
     */
    @Override
    @Transactional(readOnly = true)
    public List<BingoNumber> getBingoNumbers() {
        return (List<BingoNumber>) bingoNumberRepository.findAll();
    }

    /**
     * Deletes all the bingo numbers
     */
    @Override
    @Transactional
    public void deleteBingoNumbers() {
        bingoNumberRepository.deleteAll();
    }
}
