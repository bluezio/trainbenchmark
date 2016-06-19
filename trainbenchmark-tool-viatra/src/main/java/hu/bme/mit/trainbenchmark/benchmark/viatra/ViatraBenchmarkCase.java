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
package hu.bme.mit.trainbenchmark.benchmark.viatra;

import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;

import hu.bme.mit.trainbenchmark.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.benchmark.viatra.comparators.ViatraMatchComparator;
import hu.bme.mit.trainbenchmark.benchmark.viatra.config.ViatraBenchmarkConfigWrapper;
import hu.bme.mit.trainbenchmark.benchmark.viatra.driver.ViatraBaseDriver;
import hu.bme.mit.trainbenchmark.benchmark.viatra.driver.ViatraDriver;
import hu.bme.mit.trainbenchmark.railway.RailwayElement;

public class ViatraBenchmarkCase<TMatch extends BasePatternMatch> extends AbstractBenchmarkCase< //
TMatch, //
RailwayElement, //
ViatraBaseDriver<TMatch>, //
ViatraBenchmarkConfigWrapper> {

	@Override
	public ViatraDriver<TMatch> createDriver(final ViatraBenchmarkConfigWrapper benchmarkConfigWrapper) throws Exception {
		return new ViatraDriver<>();
	}

	@Override
	public ViatraMatchComparator<TMatch> getMatchComparator() {
		return ViatraMatchComparator.create();
	}

}