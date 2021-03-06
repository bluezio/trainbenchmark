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

package hu.bme.mit.trainbenchmark.benchmark.config;

import java.util.Collection;

import hu.bme.mit.trainbenchmark.config.AbstractConfig;
import hu.bme.mit.trainbenchmark.constants.RailwayOperation;

public final class BenchmarkConfigCore extends AbstractConfig {

	protected long timeout; // in seconds
	protected int runs;
	protected int queryTransformationCount;
	protected String toolName;
	protected String modelFilename;
	protected Collection<RailwayOperation> railwayOperations;
	protected String workload;

	protected BenchmarkConfigCore() {
	}

	public BenchmarkConfigCore(final String xms, final String xmx, final long timeout, final int runs,
			final int queryTransformationCount, final String modelFilename,
			final Collection<RailwayOperation> railwayOperations, final String workload) {
		super(xms, xmx);
		this.timeout = timeout;
		this.runs = runs;
		this.queryTransformationCount = queryTransformationCount;
		this.modelFilename = modelFilename;
		this.railwayOperations = railwayOperations;
		this.workload = workload;
	}

	public long getTimeout() {
		return timeout;
	}

	public int getRuns() {
		return runs;
	}

	public int getQueryTransformationCount() {
		return queryTransformationCount;
	}

	public String getToolName() {
		return toolName;
	}

	public String getModelPath() {
		return getModelDir() + modelFilename;
	}

	public Collection<RailwayOperation> getRailwayOperations() {
		return railwayOperations;
	}

	/**
	 * @return An identifier for the workload. Example: "Query mix, Repair transformation"
	 */
	public String getWorkload() {
		return workload;
	}
	
	public String getModelFilename() {
		return modelFilename;
	}

}
