package hu.bme.mit.trainbenchmark.generator.minimal;

import static hu.bme.mit.trainbenchmark.constants.ModelConstants.ELEMENTS;
import static hu.bme.mit.trainbenchmark.constants.ModelConstants.REGION;
import static hu.bme.mit.trainbenchmark.constants.ModelConstants.SWITCH;

import java.io.FileNotFoundException;
import java.io.IOException;

import hu.bme.mit.trainbenchmark.generator.ModelSerializer;
import hu.bme.mit.trainbenchmark.generator.config.GeneratorConfigWrapper;

public class MinimalSwitchMonitoredGenerator extends MinimalModelGenerator {

	public MinimalSwitchMonitoredGenerator(final ModelSerializer serializer, final GeneratorConfigWrapper generatorConfigWrapper) {
		super(serializer, generatorConfigWrapper);
	}

	@Override
	protected void buildPatternModel() throws FileNotFoundException, IOException {
		final Object region = serializer.createVertex(REGION);
		final Object sw = serializer.createVertex(SWITCH);

		serializer.createEdge(ELEMENTS, region, sw);
	}

}
