package spacesurvivaltest;

import java.util.Collections;
import java.util.List;

import spacesurvival.EnergyCalculator;
import spacesurvival.EnergyEventIdea;
import testutil.AbstractTest;

public class EnergyCalculatorSmokeTest extends AbstractTest {
	
	//--------------------------
	//Main (Entry Point)
	
	public static void main(String[] args) {
		EnergyCalculatorSmokeTest test = new EnergyCalculatorSmokeTest();
		test.emptyEnergySources();
		test.testConstruct();
		test.testCalculate();
		test.testNoEnergySources();
		test.printSummary();
	}
	
	//--------------------------
	//Test Data	

	private List<EnergyEventIdea> emptyEnergySources() {
		//Testing convenience helper
		//TODO -- optional -- convenient for calculator construction
		//Return empty list of sources (list size = 0)
		List<EnergyEventIdea> emptyList = Collections.emptyList();
		assertEquals(0, emptyList.size());
		return emptyList;
	}	
	
	//--------------------------
	//Tests

	private void testConstruct() {
		header("Starting -- testConstruct");
		//Simply test that we can construct w/o blowing up
		List<EnergyEventIdea> emptyList = emptyEnergySources();
		EnergyCalculator calculator = new EnergyCalculator(emptyList);

		// If List is empty, we'll pass in an empty list to be instantiated
		assertTrue(emptyList.isEmpty());
	}
	
	private void testCalculate() {
		header("Starting -- testConstruct");
		//Simply test that we can compute w/o blowing up
		List<EnergyEventIdea> emptyList = emptyEnergySources();
		EnergyCalculator calculator = new EnergyCalculator(emptyList);
		calculator.compute();

		//If we get here (did not hit exception) we pass
		assertTrue(true);
	}
	
	private void testNoEnergySources() {
		header("Starting -- testNoEnergySources");
		//Should calculate zero energy
		List<EnergyEventIdea> emptyList = emptyEnergySources();
		EnergyCalculator calculator = new EnergyCalculator(emptyList);
		calculator.compute();

		assertEquals(0, calculator.getTotalEnergy());
	}	
	
}