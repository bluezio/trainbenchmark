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
package hu.bme.mit.trainbenchmark.benchmark.neo4j.transformations.inject;

import static hu.bme.mit.trainbenchmark.constants.ModelConstants.CURRENTPOSITION;

import hu.bme.mit.trainbenchmark.benchmark.neo4j.driver.Neo4jDriver;
import hu.bme.mit.trainbenchmark.constants.ModelConstants;
import hu.bme.mit.trainbenchmark.constants.Position;

import java.util.Collection;

import org.neo4j.graphdb.Node;

public class Neo4jTransformationInjectSwitchSet extends Neo4jTransformationInject {

	public Neo4jTransformationInjectSwitchSet(final Neo4jDriver driver) {
		super(driver);
	}

	@Override
	public void activate(final Collection<Node> switches) {
		for (final Node sw : switches) {
			final String currentPositionString = (String) sw.getProperty(ModelConstants.CURRENTPOSITION);
			final Position currentPosition = Position.valueOf(currentPositionString);
			final Position newCurrentPosition = Position.values()[(currentPosition.ordinal() + 1) % Position.values().length];
			sw.setProperty(CURRENTPOSITION, newCurrentPosition.toString());
		}
	}

}
