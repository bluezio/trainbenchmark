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
package hu.bme.mit.trainbenchmark.benchmark.drools5.queries;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.rule.LiveQuery;

import hu.bme.mit.trainbenchmark.benchmark.drools5.Drools5ResultListener;
import hu.bme.mit.trainbenchmark.benchmark.drools5.driver.Drools5Driver;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfMatch;
import hu.bme.mit.trainbenchmark.benchmark.operations.ModelQuery;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

public class Drools5Query<TMatch extends EmfMatch> extends ModelQuery<TMatch, Drools5Driver> {

	protected Collection<TMatch> matches;
	protected Drools5ResultListener listener;
	protected LiveQuery liveQuery;

	protected Drools5Query(final Drools5Driver driver, final Optional<String> workspaceDir, final RailwayQuery query)
			throws IOException {
		super(query, driver);

		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		final String queryFile = workspaceDir.get() + "/trainbenchmark-tool-drools5/src/main/resources/queries/" + query
				+ ".drl";
		kbuilder.add(ResourceFactory.newFileResource(queryFile), ResourceType.DRL);

		final KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (final KnowledgeBuilderError error : errors) {
				throw new IOException("Error encountered while reading knowledge base: " + error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		driver.getKbase().addKnowledgePackages(kbuilder.getKnowledgePackages());

	}

	public static <TMatch extends EmfMatch> Drools5Query<TMatch> create(final Drools5Driver driver, final Optional<String> workspaceDir, final RailwayQuery query) throws IOException {
		return new Drools5Query<TMatch>(driver, workspaceDir, query);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<TMatch> evaluate() throws IOException {
		if (liveQuery == null) {
			listener = new Drools5ResultListener(query);
			liveQuery = driver.getKsession().openLiveQuery(query.toString(), new Object[] {}, listener);
		}
		matches = (Collection<TMatch>) listener.getMatches();
		return matches;
	}

	@Override
	public void close() {
		if (liveQuery != null) {
			liveQuery.close();
		}
	}

}
