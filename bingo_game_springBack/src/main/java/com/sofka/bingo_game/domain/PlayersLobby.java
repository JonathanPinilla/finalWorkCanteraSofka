package com.sofka.bingo_game.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity of a players_lobby
 *
 * @version 1.0.0 2022-07-04
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "players_lobby")
public class PlayersLobby implements Serializable {

    /**
     * Variable to manage de ID of the tuple
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id of a player (email)
     */
    @Id
    @Column(name = "player_id", nullable = false, length = 100)
    private String id;

    /**
     * Name of a player
     */
    @Column(name = "player_name", nullable = false, length = 100)
    private String playerName;

    /**
     * Link point with the game by game id
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Game.class, optional = false)
    @JoinColumn(name = "player_game", nullable = false)
    @JsonBackReference
    private Game playerGame;

    @JsonProperty("playerGame")
    private void unpackNested(Integer player_game) {
        this.playerGame = new Game();
        playerGame.setId(player_game);
    }
}