import hu.bme.mit.trainbenchmark.constants.Scenario
import hu.bme.mit.trainbenchmark.generator.config.GeneratorConfig
import hu.bme.mit.trainbenchmark.generator.emf.config.EmfGeneratorConfigWrapper
import hu.bme.mit.trainbenchmark.generator.graph.neo4j.config.Neo4jGraphGeneratorConfigWrapper
import hu.bme.mit.trainbenchmark.generator.graph.tinkerpop.config.TinkerGraphFormat
import hu.bme.mit.trainbenchmark.generator.graph.tinkerpop.config.TinkerGraphGeneratorConfigWrapper
import hu.bme.mit.trainbenchmark.generator.rdf.config.RdfGeneratorConfigWrapper
import hu.bme.mit.trainbenchmark.generator.runner.GeneratorRunner
import hu.bme.mit.trainbenchmark.generator.sql.config.SqlGeneratorConfigWrapper
import hu.bme.mit.trainbenchmark.rdf.RdfFormat

def xms = "4G"
def xmx = "8G"
def minSize = 1
def maxSize = 2

def scenarios = [
//	Scenario.BATCH,
//	Scenario.INJECT,
	Scenario.REPAIR,
]

def generate(String xms, String xmx, Scenario scenario, int size) {
	def gc = new GeneratorConfig(xms, xmx, scenario, size)

	// EMF
	def egcw = new EmfGeneratorConfigWrapper(gc)
	GeneratorRunner.run(egcw)

	// graph / Neo4j
	def ngcw = new Neo4jGraphGeneratorConfigWrapper(gc)
	GeneratorRunner.run(ngcw)

	// graph / TinkerPop
	def tgcw = new TinkerGraphGeneratorConfigWrapper(gc, TinkerGraphFormat.GRAPHSON)
	GeneratorRunner.run(tgcw)

	// RDF
	def rdfFormats = [RdfFormat.TURTLE]
	def includeInferredOptions = [true, false]
	for (rdfFormat in rdfFormats) {
		for (includeInferredOption in includeInferredOptions) {
			def rgcw = new RdfGeneratorConfigWrapper(gc, includeInferredOption, rdfFormat)
			GeneratorRunner.run(rgcw)
		}
	}

	// SQL
	def sgcw = new SqlGeneratorConfigWrapper(gc)
	GeneratorRunner.run(sgcw)
}

for (scenario in scenarios) {
	for (size = minSize; size <= maxSize; size *= 2) {
		println("Scenario: ${scenario}, size: ${size}")
		generate(xms, xmx, scenario, size)
	}
}
