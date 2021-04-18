package com.leokom.games.chess.engine;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.leokom.games.commons.engine.GameState;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.leokom.games.chess.engine.InitialPosition.getPawnInitialRank;
import static com.leokom.games.commons.utils.CollectionUtils.filterMapByValues;
import static java.util.stream.Collectors.toSet;

//Snapshot of the position class
//Used to restore the position class
public class PositionSnapshot {

	//All vars from position
	private Map< String, Piece > pieces = new HashMap<>();
	private Set< Side > hasKingMoved = new HashSet<>();
	private Set< Side > hasARookMoved = new HashSet<>();
	private Set< Side > hasHRookMoved = new HashSet<>();
	private Set< Side > hasCastlingExecuted = new HashSet<>();
	private Side sideToMove;
	private Side movedSide;
	private Result gameResult;
	private boolean terminal;
	private Side winningSide;
	private boolean waitingForAcceptDraw;
	private Rules rules;
	
	//Constructor to make a copy of position
	public PositionSnapshot(Map<String,Piece> pieces, Set< Side > hasKingMoved, Set< Side > hasARookMoved,
			Set< Side > hasHRookMoved, Set< Side > hasCastlingExecuted, Side sideToMove, Side movedSide,
			Result gameResult, boolean terminal, Side winningSide, boolean waitingForAcceptDraw, Rules rules)
	{
		this.pieces = new HashMap<>();
		this.pieces.putAll(pieces);
		this.hasKingMoved = new HashSet<>();
		this.hasKingMoved.addAll(hasKingMoved);
		this.hasARookMoved = new HashSet<>();
		this.hasARookMoved.addAll(hasARookMoved);
		this.hasHRookMoved = new HashSet<>();
		this.hasHRookMoved.addAll(hasHRookMoved);
		this.hasCastlingExecuted = new HashSet<>();
		this.hasCastlingExecuted.addAll(hasCastlingExecuted);
		this.sideToMove = sideToMove;
		this.movedSide = movedSide;
		this.gameResult = gameResult;
		this.terminal = terminal;
		this.winningSide = winningSide;
		this.waitingForAcceptDraw = waitingForAcceptDraw;
		this.rules = rules;
		
		//Store the snapshot of the instance
		PositionHistory.getInstance().addSnapshot(this);
	}
	
	//Restore this snapshot to the passed position
	public void restore(Position position)
	{
		position.setState(pieces, hasKingMoved, hasARookMoved,
				hasHRookMoved, hasCastlingExecuted,  sideToMove, movedSide,
				 gameResult,  terminal, winningSide,  waitingForAcceptDraw,  rules);
	}
}
