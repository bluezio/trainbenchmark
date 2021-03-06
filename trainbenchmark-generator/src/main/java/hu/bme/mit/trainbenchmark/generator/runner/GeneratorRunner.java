package hu.bme.mit.trainbenchmark.generator.runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import hu.bme.mit.trainbenchmark.generator.config.GeneratorConfigWrapper;

public class GeneratorRunner {

	public static int run(final GeneratorConfigWrapper gcw)
			throws IOException, InterruptedException {
		final File configFile = File.createTempFile("trainbenchmark-generator-", ".conf");
		final String configPath = configFile.getAbsolutePath();
		gcw.saveToFile(configPath);

		final String projectName = String.format("trainbenchmark-generator-%s", gcw.getProjectName());
		final String jarPath = String.format("../%s/build/libs/%s-1.0.0-SNAPSHOT-fat.jar", projectName, projectName);
		final String javaCommand = String.format("java -Xms%s -Xmx%s -server -jar %s %s",
				gcw.getGeneratorConfig().getXms(), gcw.getGeneratorConfig().getXmx(), jarPath, configPath);
		
		final CommandLine cmdLine = CommandLine.parse(javaCommand);
		final DefaultExecutor executor = new DefaultExecutor();
		final int exitValue = executor.execute(cmdLine);

		return exitValue;
	}

}
