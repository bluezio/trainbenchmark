/*******************************************************************************
 * Copyright (c) 2010-2014, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.trainbenchmark.benchmark.jena;

import hu.bme.mit.trainbenchmark.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.rdf.RDFBenchmarkConfig;

import org.apache.commons.cli.ParseException;

public class JenaBenchmarkLogic extends AbstractBenchmarkLogic {

	protected RDFBenchmarkConfig rbc;

	public JenaBenchmarkLogic(final String[] args) throws ParseException {
		super(args);
		bc = rbc = new RDFBenchmarkConfig(args, getTool());

	}

	@Override
	protected String getTool() {
		return "Jena";
	}

}
