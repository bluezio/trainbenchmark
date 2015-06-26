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

package hu.bme.mit.trainbenchmark.benchmark.util;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.constants.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Stopwatch;

public class BenchmarkResult {

	protected BenchmarkConfig bc;
	protected Stopwatch stopwatch;

	public BenchmarkResult(final BenchmarkConfig bc) {
		super();
		this.bc = bc;
	}

	public static BenchmarkResult newInstance(final BenchmarkConfig bc) {
		return new BenchmarkResult(bc);
	}

	@JsonProperty("ModifiedElements")
	protected List<Long> modifiedMatchCounts = new ArrayList<>();

	@JsonProperty("Memory")
	protected List<Long> memoryUsages = new ArrayList<>();

	@JsonProperty("Results")
	protected List<Integer> matchCounts = new ArrayList<>();

	// phase 1
	@JsonProperty("ReadTime")
	protected Long readTime;

	// phase 2
	@JsonProperty("CheckTimes")
	protected List<Long> checkTimes = new ArrayList<>();
	// phase 3
	@JsonProperty("LHSTimes")
	protected List<Long> lhsTimes = new ArrayList<>();

	@JsonProperty("RHSTimes")
	protected List<Long> rhsTimes = new ArrayList<>();

	// JSON properties
	@JsonProperty("Size")
	public int getSize() {
		return bc.getSize();
	}

	@JsonProperty("Scenario")
	public String getScenario() {
		return bc.getScenarioName();
	}

	@JsonProperty("RunIndex")
	public int getRunIndex() {
		return bc.getRunIndex();
	}

	@JsonProperty("Tool")
	public String getTool() {
		return bc.getTool();
	}

	@JsonProperty("Query")
	public Query getQuery() {
		return bc.getQuery();
	}

	// benchmarkconfig

	public BenchmarkConfig getBenchmarkConfig() {
		return bc;
	}

	public void setBenchmarkConfig(final BenchmarkConfig bc) {
		this.bc = bc;
	}

	// timing

	public void restartClock() {
		stopwatch = Stopwatch.createStarted();
	}

	public long stopClock() {
		stopwatch.stop();
		final long nanos = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		return nanos;
	}

	// phase 1
	public void setReadTime() {
		readTime = stopClock();
	}

	// phase 2
	public void addCheckTime() {
		checkTimes.add(stopClock());
	}

	// phase 3
	public void addLhsTime() {
		lhsTimes.add(stopClock());
	}

	public void addRhsTime() {
		rhsTimes.add(stopClock());
	}

	// memory usage

	public void addMemoryUsage(final long memoryUsage) {
		memoryUsages.add(memoryUsage);
	}

	// modification parameters

	public void addModifiedMatchCount(final long modifiedMatchCount) {
		modifiedMatchCounts.add(modifiedMatchCount);
	}

	// result sizes

	public void addMatchCount(final int matchCount) {
		matchCounts.add(matchCount);
	}

	public List<Integer> getMatchCounts() {
		return matchCounts;
	}

	public long getLastMatchCount() {
		return matchCounts.get(matchCounts.size() - 1);
	}

	@Override
	public String toString() {
		// @formatter:off
		return
			"Benchmark results\n" +
			"-----------------\n" +
			"Scenario: " + getScenario() + "\n" +
			"Query: " + getQuery() + "\n" +
			"Tool: " + getTool() + "\n" +
			"Match counts: " + matchCounts + "\n" +
			"Read time: " + readTime + "\n" + 	
			"Check time: " + checkTimes + "\n" + 	
			"LHS times: " + lhsTimes + "\n" + 	
			"RHS times: " + rhsTimes + "\n" + 	
			"Modified match counts: " + modifiedMatchCounts + "\n" 
			;
		// @formatter:on
	}

	public void publish() throws IOException {
		ResultSerializer.serializeToJSON(this);
	}

}