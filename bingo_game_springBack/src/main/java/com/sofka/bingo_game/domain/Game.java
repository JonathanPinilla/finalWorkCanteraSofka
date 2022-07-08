package com.sofka.bingo_game.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity of a Game
 *
 * @version 1.0.0 2022-07-04
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

    /**
     * Variable to manage de ID of the tuple
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id of a game
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Integer id;

    /**
     * Indicates if the game is running or stopped
     */
    @Column(name = "is_started", nullable = false)
    private Boolean isStarted = false;

    /**
     * Indicates if the game has ended
     */
    @Column(name = "ended", nullable = false)
    private Boolean ended = false;

    /**
     * Mapp the players in the game
     */
    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = PlayersLobby.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "playerGame"
    )
    private List<PlayersLobby> playersLobbies = new ArrayList<>();

}