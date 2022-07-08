package com.sofka.bingo_game.repositories;

import com.sofka.bingo_game.domain.PlayersLobby;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for the PlayersLobby entity
 *
 * @version 1.0.0 2022-07-04
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @since 1.0.0
 */
public interface PlayersLobbyRepository extends CrudRepository<PlayersLobby, String> {
}