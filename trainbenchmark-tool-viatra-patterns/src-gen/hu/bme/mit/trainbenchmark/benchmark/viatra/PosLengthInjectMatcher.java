package hu.bme.mit.trainbenchmark.benchmark.viatra;

import hu.bme.mit.trainbenchmark.benchmark.viatra.PosLengthInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.viatra.util.PosLengthInjectQuerySpecification;
import hu.bme.mit.trainbenchmark.railway.Segment;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.trainbenchmark.benchmark.viatra.PosLengthInject pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PosLengthInjectMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern PosLengthInject(segment)
 * {
 * 	Segment(segment);
 * }
 * </pre></code>
 * 
 * @see PosLengthInjectMatch
 * @see PosLengthInjectProcessor
 * @see PosLengthInjectQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PosLengthInjectMatcher extends BaseMatcher<PosLengthInjectMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PosLengthInjectMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    PosLengthInjectMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new PosLengthInjectMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SEGMENT = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PosLengthInjectMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private PosLengthInjectMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @return matches represented as a PosLengthInjectMatch object.
   * 
   */
  public Collection<PosLengthInjectMatch> getAllMatches(final Segment pSegment) {
    return rawGetAllMatches(new Object[]{pSegment});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @return a match represented as a PosLengthInjectMatch object, or null if no match is found.
   * 
   */
  public PosLengthInjectMatch getOneArbitraryMatch(final Segment pSegment) {
    return rawGetOneArbitraryMatch(new Object[]{pSegment});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Segment pSegment) {
    return rawHasMatch(new Object[]{pSegment});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Segment pSegment) {
    return rawCountMatches(new Object[]{pSegment});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Segment pSegment, final IMatchProcessor<? super PosLengthInjectMatch> processor) {
    rawForEachMatch(new Object[]{pSegment}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Segment pSegment, final IMatchProcessor<? super PosLengthInjectMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSegment}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public PosLengthInjectMatch newMatch(final Segment pSegment) {
    return PosLengthInjectMatch.newMatch(pSegment);
  }
  
  /**
   * Retrieve the set of values that occur in matches for segment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Segment> rawAccumulateAllValuesOfsegment(final Object[] parameters) {
    Set<Segment> results = new HashSet<Segment>();
    rawAccumulateAllValues(POSITION_SEGMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for segment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Segment> getAllValuesOfsegment() {
    return rawAccumulateAllValuesOfsegment(emptyArray());
  }
  
  @Override
  protected PosLengthInjectMatch tupleToMatch(final Tuple t) {
    try {
    	return PosLengthInjectMatch.newMatch((Segment) t.get(POSITION_SEGMENT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PosLengthInjectMatch arrayToMatch(final Object[] match) {
    try {
    	return PosLengthInjectMatch.newMatch((Segment) match[POSITION_SEGMENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PosLengthInjectMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return PosLengthInjectMatch.newMutableMatch((Segment) match[POSITION_SEGMENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<PosLengthInjectMatcher> querySpecification() throws ViatraQueryException {
    return PosLengthInjectQuerySpecification.instance();
  }
}
