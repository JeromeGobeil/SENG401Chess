package com.leokom.games.chess.player.legal.brain.common;

public interface EvaluatorFactory {
	Evaluator get( EvaluatorType type );
}
