package com.leokom.games.chess.player.legal.brain.common;

import com.leokom.games.chess.player.legal.brain.common.EvaluatorFactory;
import com.leokom.games.chess.player.legal.brain.normalized.NormalizedEvaluatorFactory;
import com.leokom.games.chess.player.legal.brain.denormalized.DenormalizedEvaluatorFactory;

public class EvaluatorFactoryCreator
{
    //Return EvalutatorFactory of factoryType ("normalized", "denormalized")
    public static EvaluatorFactory getEvaluatorFactory(String factoryType)
    {
        switch (factoryType)
        {
            case "normalized":
                return new NormalizedEvaluatorFactory();
            case "denormalized":
                return new DenormalizedEvaluatorFactory();
            default:
                throw new IllegalArgumentException( "The evaluator factory is not supported: " + factoryType);

        }
    }
} 