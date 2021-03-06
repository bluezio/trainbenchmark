package hu.bme.mit.trainbenchmark.benchmark.eclipseocl.config;

import hu.bme.mit.trainbenchmark.benchmark.eclipseocl.operations.EclipseOclModelOperationFactory;
import hu.bme.mit.trainbenchmark.benchmark.emf.comparators.EmfMatchComparator;
import hu.bme.mit.trainbenchmark.benchmark.emf.driver.EmfDriver;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfMatch;
import hu.bme.mit.trainbenchmark.benchmark.phases.BenchmarkScenario;

public class EclipseOclBenchmarkScenario extends BenchmarkScenario<EmfMatch, EmfDriver, EclipseOclBenchmarkConfigWrapper> {

	public EclipseOclBenchmarkScenario(final EclipseOclBenchmarkConfigWrapper dbcw) throws Exception {
		super(EmfDriver.create(), EclipseOclModelOperationFactory.create(), EmfMatchComparator.create(), dbcw);
	}

}
