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
package hu.bme.mit.trainbenchmark.benchmark.sql.transformations.inject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import hu.bme.mit.trainbenchmark.benchmark.sql.driver.SqlDriver;
import hu.bme.mit.trainbenchmark.benchmark.sql.transformations.SqlTransformation;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

public class SqlTransformationInject<TSqlDriver extends SqlDriver> extends SqlTransformation<Long, TSqlDriver> {

	public SqlTransformationInject(final TSqlDriver driver, final Optional<String> workspaceDir, final RailwayQuery query)
			throws IOException {
		super(driver, workspaceDir, query, "Inject");
	}

	@Override
	public void activate(final Collection<Long> elements) throws SQLException {
		if (preparedUpdateStatement == null) {
			preparedUpdateStatement = driver.getConnection().prepareStatement(updateQuery);
		}

		for (final Long element : elements) {
			preparedUpdateStatement.setLong(1, element);
			preparedUpdateStatement.executeUpdate();
		}
	}

}
