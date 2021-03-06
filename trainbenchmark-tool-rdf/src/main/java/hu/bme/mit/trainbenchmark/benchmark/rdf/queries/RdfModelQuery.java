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
package hu.bme.mit.trainbenchmark.benchmark.rdf.queries;

import java.util.Optional;

import hu.bme.mit.trainbenchmark.benchmark.driver.Driver;
import hu.bme.mit.trainbenchmark.benchmark.operations.ModelQuery;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

public abstract class RdfModelQuery<TMatch, TDriver extends Driver<?>> extends ModelQuery<TMatch, TDriver> {

	protected final String queryPath;

	public RdfModelQuery(final TDriver driver, final Optional<String> workspaceDir, final RailwayQuery query) {
		super(query, driver);
		this.queryPath = workspaceDir.get() + "trainbenchmark-tool-rdf/src/main/resources/queries/" + query + ".sparql";
	}

}
