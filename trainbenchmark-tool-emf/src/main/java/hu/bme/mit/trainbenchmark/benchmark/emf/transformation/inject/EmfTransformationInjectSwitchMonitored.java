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
package hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject;

import java.io.IOException;
import java.util.Collection;

import hu.bme.mit.trainbenchmark.benchmark.emf.driver.EmfDriver;
import hu.bme.mit.trainbenchmark.railway.Switch;

public class EmfTransformationInjectSwitchMonitored extends EmfTransformationInject<Switch> {

	public EmfTransformationInjectSwitchMonitored(final EmfDriver driver) {
		super(driver);
	}

	@Override
	public void activate(final Collection<Switch> switches) throws IOException {
		for (final Switch sw : switches) {
			sw.getMonitoredBy().clear();
		}
	}

}
