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

//Class to keep track of all the generated snapshots
//Implemented as a singleton as there should only ever be one history
public class PositionHistory {

	//List that keeps track of the entire history of all the positions
	private ArrayList<PositionSnapshot> positionHistory = new ArrayList<PositionSnapshot>();
	
	//instance of the history
	private static PositionHistory instance;
	
	//Private constructor
	private PositionHistory()
	{
		positionHistory = new ArrayList<PositionSnapshot>();
	}
	
	//How to get the position history instace
	public static PositionHistory getInstance()
	{
		if (instance == null)
			instance = new PositionHistory();
		
		return instance;
	}
	
	//Add a new snapshot to the position history
	public void addSnapshot(PositionSnapshot snapshot)
	{
		positionHistory.add(snapshot);
	}
	
	//Pop the latest version of the history
	//could be used for a undo feature
	public PositionSnapshot popLatestSnapshot()
	{
		PositionSnapshot last = positionHistory.get(positionHistory.size()-1);
		positionHistory.remove(last);
		return last;
		
	}
	
	//Returns the entire arrayList of history
	//could be used to display the sequence of moves made
	public ArrayList<PositionSnapshot> getEntireHistory()
	{
		return positionHistory;
		
	}
	
	//Other methods to retrieve specific snapshots could also be added
	
}
