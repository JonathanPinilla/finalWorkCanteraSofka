package com.sofka.bingo_game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity of a BingoNumber
 *
 * @version 1.0.0 2022-07-07
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "bingo_numbers")
public class BingoNumber implements Serializable {

    /**
     * Variable to manage de ID of the tuple
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id of a Ball number
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ball_id", nullable = false, length = 100)
    private Integer id;

    /**
     * Value of a ball number
     */
    @Column(name = "ball_number", nullable = false)
    private Integer ballNumber;

    public BingoNumber(Integer ballNumber) {
        this.ballNumber = ballNumber;
    }

    public BingoNumber() {
    }

}