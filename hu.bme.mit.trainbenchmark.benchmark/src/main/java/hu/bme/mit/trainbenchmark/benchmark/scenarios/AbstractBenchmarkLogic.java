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

package hu.bme.mit.trainbenchmark.benchmark.scenarios;

import hu.bme.mit.trainbenchmark.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfig;

import java.io.IOException;
import java.lang.reflect.Modifier;

public abstract class AbstractBenchmarkLogic {

	protected BenchmarkConfig bc;

	public AbstractBenchmarkLogic() {		
	}
	
	public AbstractBenchmarkLogic(final BenchmarkConfig bc) {
		this.bc = bc;
	}
	
	@SuppressWarnings("unchecked")
	public void runBenchmark() throws IOException {
		@SuppressWarnings("rawtypes")
		final ScenarioLogic scl = ScenarioFactory.getScenario(bc.getScenario());
		final AbstractBenchmarkCase<?, ?> tc = getBenchmarkCase();
		scl.runBenchmark(bc, tc);
	}

	public AbstractBenchmarkCase<?, ?> getBenchmarkCase() {
		return getTestCase(this.getClass().getClassLoader());
	}

	protected AbstractBenchmarkCase<?, ?> getTestCase(final ClassLoader classLoader) {
		try {
			// trying to loading generic class
			final String toolClassName = "hu.bme.mit.trainbenchmark.benchmark." + getTool().toLowerCase() + "." + getTool()
					+ "BenchmarkCase";
			final Class<?> clazz = classLoader.loadClass(toolClassName);

			final int modifiers = clazz.getModifiers();
			// instantiate generic class if not abstract
			if (!Modifier.isAbstract(modifiers)) {
				return (AbstractBenchmarkCase<?, ?>) clazz.newInstance();
			}
		

			// else instantiate specific class
			final String queryClassName = "hu.bme.mit.trainbenchmark.benchmark." + getTool().toLowerCase() + "." + getTool() + bc.getQuery();
			final Class<?> queryClass = classLoader.loadClass(queryClassName);
			
			// instantiate generic class if not abstract
			return (AbstractBenchmarkCase<?, ?>) queryClass.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BenchmarkConfig getBc() {
		return bc;
	}

	protected abstract String getTool();
}