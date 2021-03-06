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
package hu.bme.mit.trainbenchmark.benchmark.neo4j.matches;

import static hu.bme.mit.trainbenchmark.constants.QueryConstants.VAR_SW;
import hu.bme.mit.trainbenchmark.benchmark.matches.SwitchMonitoredMatch;

import java.util.Map;

import org.neo4j.graphdb.Node;

public class Neo4jSwitchMonitoredMatch extends Neo4jMatch implements SwitchMonitoredMatch {

	public Neo4jSwitchMonitoredMatch(final Map<String, Object> match) {
		super(match);
	}

	@Override
	public Node getSw() {
		return (Node) match.get(VAR_SW);
	}

	@Override
	public Node[] toArray() {
		return new Node[] { getSw() };
	}

}
