/*******************************************************************************
 * Copyright (c) 2010-2015, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.trainbenchmark.benchmark.tinkergraph.queries;

import static hu.bme.mit.trainbenchmark.constants.ModelConstants.LENGTH;
import static hu.bme.mit.trainbenchmark.constants.ModelConstants.SEGMENT;
import static hu.bme.mit.trainbenchmark.constants.QueryConstants.VAR_LENGTH;
import static hu.bme.mit.trainbenchmark.constants.QueryConstants.VAR_SEGMENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.tinkerpop.gremlin.structure.Vertex;

import hu.bme.mit.trainbenchmark.benchmark.tinkergraph.driver.TinkerGraphDriver;
import hu.bme.mit.trainbenchmark.benchmark.tinkergraph.matches.TinkerGraphPosLengthMatch;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

public class TinkerGraphQueryPosLength<TTinkerGraphDriver extends TinkerGraphDriver> extends TinkerGraphQuery<TinkerGraphPosLengthMatch, TTinkerGraphDriver> {

	public TinkerGraphQueryPosLength(final TTinkerGraphDriver driver) {
		super(RailwayQuery.POSLENGTH, driver);
	}

	@Override
	public Collection<TinkerGraphPosLengthMatch> evaluate() {
		final Collection<TinkerGraphPosLengthMatch> matches = new ArrayList<>();

		final Collection<Vertex> segments = driver.collectVertices(SEGMENT);
		
		// (segment:Segment)
		for (final Vertex segment : segments) {
			final Integer length = (Integer) segment.property(LENGTH).value();
			
			// segment.length <= 0
			if (length <= 0) {
				final Map<String, Object> match = new HashMap<>();
				match.put(VAR_SEGMENT, segment);
				match.put(VAR_LENGTH, length);
				matches.add(new TinkerGraphPosLengthMatch(match));
			}			
		}

		return matches;
	}
}
