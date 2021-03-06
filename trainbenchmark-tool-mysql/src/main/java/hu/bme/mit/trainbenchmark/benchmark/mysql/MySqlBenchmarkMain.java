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

package hu.bme.mit.trainbenchmark.benchmark.mysql;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfigWrapper;
import hu.bme.mit.trainbenchmark.benchmark.mysql.config.MySqlBenchmarkConfigWrapper;

public class MySqlBenchmarkMain {

	public static void main(final String[] args) throws Exception {
		final MySqlBenchmarkConfigWrapper bcw = BenchmarkConfigWrapper.fromFile(args[0], MySqlBenchmarkConfigWrapper.class);
		final MySqlBenchmarkScenario scenario = new MySqlBenchmarkScenario(bcw);
		scenario.performBenchmark();
	}

}
