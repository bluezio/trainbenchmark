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

package hu.bme.mit.trainbenchmark.benchmark.iqdcore.noinferencing.test;

import hu.bme.mit.trainbenchmark.benchmark.iqdcore.IQDCoreBenchmarkCase;
import hu.bme.mit.trainbenchmark.benchmark.iqdcore.config.Checker;
import hu.bme.mit.trainbenchmark.benchmark.scenarios.BenchmarkRunner;
import hu.bme.mit.trainbenchmark.benchmark.test.TestBenchmarkInitializer;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

import hu.bme.mit.trainbenchmark.constants.ScenarioEnum;

public class IQDCoreBenchmarkNoInferencingInitializer extends TestBenchmarkInitializer {
	@Override
	protected BenchmarkRunner initializeBenchmark(RailwayQuery query, ScenarioEnum scenario) {
		final IQDCoreBenchmarkConfig iqdbc = new IQDCoreBenchmarkConfig(scenario, size, 1, query, iterationCount, transformationStrategy,
				transformationConstant, null, Checker.LOCAL, 16);
		return new BenchmarkRunner(iqdbc, new IQDCoreBenchmarkCase(iqdbc));
	}
}
