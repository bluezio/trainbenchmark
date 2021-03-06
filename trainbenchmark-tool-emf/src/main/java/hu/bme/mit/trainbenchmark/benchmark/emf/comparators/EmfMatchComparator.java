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
package hu.bme.mit.trainbenchmark.benchmark.emf.comparators;

import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfMatch;
import hu.bme.mit.trainbenchmark.benchmark.matches.comparators.MatchComparator;
import hu.bme.mit.trainbenchmark.railway.RailwayElement;

public class EmfMatchComparator extends MatchComparator<EmfMatch, RailwayElement> {

	protected EmfMatchComparator() {
		super(new RailwayElementComparator());
	}
	
	public static EmfMatchComparator create() {
		return new EmfMatchComparator();
	}
	
	@Override
	public int compare(final EmfMatch o1, final EmfMatch o2) {
		final RailwayElement[] m1 = o1.getMatch();
		final RailwayElement[] m2 = o2.getMatch();
		return compareArrays(m1, m2);
	}

}
