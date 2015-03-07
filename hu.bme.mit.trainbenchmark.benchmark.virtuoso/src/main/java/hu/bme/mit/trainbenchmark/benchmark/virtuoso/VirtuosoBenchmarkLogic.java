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

package hu.bme.mit.trainbenchmark.benchmark.virtuoso;

import org.apache.commons.cli.ParseException;

import hu.bme.mit.trainbenchmark.benchmark.scenarios.GenericBenchmarkLogic;
import hu.bme.mit.trainbenchmark.rdf.RDFBenchmarkConfig;

public class VirtuosoBenchmarkLogic extends GenericBenchmarkLogic{

	public VirtuosoBenchmarkLogic(String[] args) throws ParseException {
		super(args);
		bc = new RDFBenchmarkConfig(args, getTool());
	}

	@Override
	protected String getTool() {
		return "Virtuoso";
	}

}
