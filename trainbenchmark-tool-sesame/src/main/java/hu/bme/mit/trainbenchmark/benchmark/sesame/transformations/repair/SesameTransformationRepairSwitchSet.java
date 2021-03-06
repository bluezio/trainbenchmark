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
package hu.bme.mit.trainbenchmark.benchmark.sesame.transformations.repair;

import static hu.bme.mit.trainbenchmark.constants.ModelConstants.CURRENTPOSITION;
import static hu.bme.mit.trainbenchmark.rdf.RdfConstants.BASE_PREFIX;

import java.util.Collection;

import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.RepositoryResult;

import hu.bme.mit.trainbenchmark.benchmark.sesame.driver.SesameDriver;
import hu.bme.mit.trainbenchmark.benchmark.sesame.matches.SesameSwitchSetMatch;

public class SesameTransformationRepairSwitchSet extends SesameTransformationRepair<SesameSwitchSetMatch> {

	public SesameTransformationRepairSwitchSet(final SesameDriver driver) {
		super(driver);
	}

	@Override
	public void activate(final Collection<SesameSwitchSetMatch> matches) throws RepositoryException {
		final RepositoryConnection con = driver.getConnection();
		final ValueFactory vf = driver.getValueFactory();

		final URI currentPositionProperty = vf.createURI(BASE_PREFIX + CURRENTPOSITION);

		for (final SesameSwitchSetMatch match : matches) {
			final Resource sw = match.getSw();
			final Value position = match.getPosition();
			final Value currentPosition = match.getCurrentPosition();

			final RepositoryResult<Statement> statementsToRemove = con.getStatements(sw, currentPositionProperty, currentPosition, false);
			while (statementsToRemove.hasNext()) {
				con.remove(statementsToRemove.next());
			}

			con.add(sw, currentPositionProperty, position);
		}
	}

}
