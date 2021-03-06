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
package hu.bme.mit.trainbenchmark.benchmark.tinkergraph.transformations.inject;

import static hu.bme.mit.trainbenchmark.constants.ModelConstants.CURRENTPOSITION;

import java.util.Collection;

import org.apache.tinkerpop.gremlin.structure.Vertex;

import hu.bme.mit.trainbenchmark.benchmark.tinkergraph.driver.TinkerGraphDriver;
import hu.bme.mit.trainbenchmark.constants.ModelConstants;
import hu.bme.mit.trainbenchmark.constants.Position;

public class TinkerGraphTransformationInjectSwitchSet<TTinkerGraphDriver extends TinkerGraphDriver> extends TinkerGraphTransformationInject<TTinkerGraphDriver> {

	public TinkerGraphTransformationInjectSwitchSet(final TTinkerGraphDriver driver) {
		super(driver);
	}

	@Override
	public void activate(final Collection<Vertex> switches) {
		for (final Vertex sw : switches) {
			final String currentPositionString = (String) sw.property(ModelConstants.CURRENTPOSITION).value();
			final Position currentPosition = Position.valueOf(currentPositionString);
			final Position newCurrentPosition = Position.values()[(currentPosition.ordinal() + 1) % Position.values().length];
			sw.property(CURRENTPOSITION, newCurrentPosition.toString());
		}
	}

}
