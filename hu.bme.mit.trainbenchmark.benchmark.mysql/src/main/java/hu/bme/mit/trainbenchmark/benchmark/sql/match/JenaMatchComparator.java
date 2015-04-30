/*******************************************************************************
 * Copyright (c) 2010-2015, Gabor Szarnyas, Benedek Izso, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.trainbenchmark.benchmark.sql.match;

import hu.bme.mit.trainbenchmark.benchmark.jena.driver.ResourceComparator;
import hu.bme.mit.trainbenchmark.benchmark.matches.MatchComparator;

import com.hp.hpl.jena.rdf.model.Resource;

public class JenaMatchComparator extends MatchComparator<SQLMatch, Resource> {

	protected ResourceComparator rc = new ResourceComparator();

	@Override
	public int compare(final SQLMatch o1, final SQLMatch o2) {
		final Resource[] m1 = o1.toArray();
		final Resource[] m2 = o2.toArray();
		return compareArrays(m1, m2, rc);
	}

}
