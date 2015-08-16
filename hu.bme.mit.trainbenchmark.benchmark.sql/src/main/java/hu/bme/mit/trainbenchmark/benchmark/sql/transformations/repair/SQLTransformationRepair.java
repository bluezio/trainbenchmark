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
package hu.bme.mit.trainbenchmark.benchmark.sql.transformations.repair;

import hu.bme.mit.trainbenchmark.benchmark.sql.driver.SQLDriver;
import hu.bme.mit.trainbenchmark.benchmark.sql.match.SQLMatch;
import hu.bme.mit.trainbenchmark.benchmark.sql.transformations.SQLTransformation;
import hu.bme.mit.trainbenchmark.constants.Query;
import hu.bme.mit.trainbenchmark.constants.ScenarioConstants;

import java.io.IOException;

public abstract class SQLTransformationRepair<M extends SQLMatch> extends SQLTransformation<M> {

	protected SQLTransformationRepair(final SQLDriver sqlDriver, final Query query,
			final ScenarioConstants scenario) throws IOException {
		super(sqlDriver, query, scenario);
	}

}
