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

package hu.bme.mit.trainbenchmark.benchmark.drools6;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.runtime.rule.Row;
import org.kie.api.runtime.rule.ViewChangedEventListener;

public class Drools6ResultListener implements ViewChangedEventListener {

	protected final Set<Row> matches = new HashSet<>();

	@Override
	public void rowInserted(final Row row) {
		matches.add(row);
	}

	@Override
	public void rowDeleted(final Row row) {
		matches.remove(row);
	}

	@Override
	public void rowUpdated(final Row row) {
		matches.add(row);
	}

	public Set<Row> getMatches() {
		return matches;
	}

}
