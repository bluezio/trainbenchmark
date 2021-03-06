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
package hu.bme.mit.trainbenchmark.benchmark.iqdcore.transformations.repair;

import hu.bme.mit.incqueryds.Transaction;
import hu.bme.mit.trainbenchmark.benchmark.iqdcore.driver.IQDCoreDriver;
import hu.bme.mit.trainbenchmark.benchmark.iqdcore.match.IQDCoreSwitchMonitoredMatch;

import java.util.Collection;

import static hu.bme.mit.trainbenchmark.constants.ModelConstants.MONITORED_BY;
import static hu.bme.mit.trainbenchmark.constants.ModelConstants.SENSOR;

public class IQDCoreTransformationRepairSwitchMonitored extends IQDCoreTransformationRepair<IQDCoreSwitchMonitoredMatch> {

	public IQDCoreTransformationRepairSwitchMonitored(final IQDCoreDriver driver) {
		super(driver);
	}

	@Override
	public void activate(final Collection<IQDCoreSwitchMonitoredMatch> matches) throws Exception {
		final Transaction transaction = driver.newTransaction();
		for (final IQDCoreSwitchMonitoredMatch match : matches) {
			final long sw = match.getSw();
			final long sensorID = driver.newKey();
			transaction.add(sensorID, "type", SENSOR);
			transaction.add(sw, MONITORED_BY, sensorID);
		}
	}
}
