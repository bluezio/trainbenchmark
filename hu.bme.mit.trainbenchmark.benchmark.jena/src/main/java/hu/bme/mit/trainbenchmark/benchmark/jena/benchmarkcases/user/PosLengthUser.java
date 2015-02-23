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

package hu.bme.mit.trainbenchmark.benchmark.jena.benchmarkcases.user;

import hu.bme.mit.trainbenchmark.benchmark.benchmarkcases.Transformation;
import hu.bme.mit.trainbenchmark.benchmark.benchmarkcases.TransformationBenchmarkCase;
import hu.bme.mit.trainbenchmark.benchmark.jena.benchmarkcases.PosLength;
import hu.bme.mit.trainbenchmark.benchmark.util.Util;
import hu.bme.mit.trainbenchmark.constants.ModelConstants;
import hu.bme.mit.trainbenchmark.rdf.RDFConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Selector;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

public class PosLengthUser extends PosLength implements TransformationBenchmarkCase {

	@Override
	public void modify() throws IOException {
		final long nElemToModify = Util.calcModify(bmr);
		bmr.addModifiedElementsSize(nElemToModify);

		// modify
		final long start = System.nanoTime();

		final ResIterator segmentStatements = model.listSubjectsWithProperty(RDF.type,
				model.getResource(RDFConstants.BASE_PREFIX + ModelConstants.SEGMENT));
		final List<Resource> segments = segmentStatements.toList();

		final List<Resource> segmentsToModify = Transformation.pickRandom(nElemToModify, segments);
		final List<Statement> itemsToRemove = new ArrayList<>();
		final List<Statement> itemsToAdd = new ArrayList<>();

		for (final Resource segment : segmentsToModify) {
			final Selector selector = new SimpleSelector(segment, model.getProperty(RDFConstants.BASE_PREFIX + ModelConstants.SEGMENT_LENGTH),
					(RDFNode) null);

			final StmtIterator statementsToRemove = model.listStatements(selector);
			while (statementsToRemove.hasNext()) {
				itemsToRemove.add(statementsToRemove.next());
			}

			final Statement newValueStmt = model.createLiteralStatement(segment,
					model.getProperty(RDFConstants.BASE_PREFIX + ModelConstants.SEGMENT_LENGTH), -1);
			itemsToAdd.add(newValueStmt);
		}

		// edit
		final long startEdit = System.nanoTime();
		for (final Statement statementToRemove : itemsToRemove) {
			model.remove(statementToRemove);
		}
		for (final Statement newValueStmt : itemsToAdd) {
			model.add(newValueStmt);
		}
		final long end = System.nanoTime();
		bmr.addEditTime(end - startEdit);
		bmr.addModificationTime(end - start);
	}

}
