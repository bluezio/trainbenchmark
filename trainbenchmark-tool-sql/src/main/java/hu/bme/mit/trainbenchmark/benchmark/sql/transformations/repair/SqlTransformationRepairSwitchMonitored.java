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

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import hu.bme.mit.trainbenchmark.benchmark.sql.driver.SqlDriver;
import hu.bme.mit.trainbenchmark.benchmark.sql.matches.SqlSwitchMonitoredMatch;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

public class SqlTransformationRepairSwitchMonitored<TSqlDriver extends SqlDriver> extends SqlTransformationRepair<SqlSwitchMonitoredMatch, TSqlDriver> {

	public SqlTransformationRepairSwitchMonitored(final TSqlDriver driver, final Optional<String> workspaceDir)
			throws IOException {
		super(driver, workspaceDir, RailwayQuery.SWITCHMONITORED);
	}

	@Override
	public void activate(final Collection<SqlSwitchMonitoredMatch> matches) throws SQLException {
		if (preparedUpdateStatement == null) {
			preparedUpdateStatement = driver.getConnection().prepareStatement(updateQuery);
		}

		for (final SqlSwitchMonitoredMatch match : matches) {
			preparedUpdateStatement.setLong(1, match.getSw());
			preparedUpdateStatement.executeUpdate();
		}
	}

}
