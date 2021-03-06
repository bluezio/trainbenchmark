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

package hu.bme.mit.trainbenchmark.benchmark.drools6.config;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfigCore;
import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfigWrapper;

public class Drools6BenchmarkConfigWrapper extends BenchmarkConfigWrapper {

	protected Drools6BenchmarkConfigWrapper() {
	}
	
	public Drools6BenchmarkConfigWrapper(final BenchmarkConfigCore benchmarkConfig) {
		super(benchmarkConfig);
	}
	
	@Override
	public String getToolName() {
		return "Drools 6";
	}

	@Override
	public String getProjectName() {
		return "drools6";
	}
	
}
