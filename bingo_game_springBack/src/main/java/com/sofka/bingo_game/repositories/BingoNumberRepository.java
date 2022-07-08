package com.sofka.bingo_game.repositories;

import com.sofka.bingo_game.domain.BingoNumber;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for the BingoNumber entity
 *
 * @version 1.0.0 2022-07-07
 * @author Jonathan Daniel Pinilla Forero <jonathan_pinilla@outlook.com>
 * @since 1.0.0
 */
public interface BingoNumberRepository extends CrudRepository<BingoNumber, Integer> {
}