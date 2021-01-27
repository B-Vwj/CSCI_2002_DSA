package spacesurvivaltest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import spacesurvival.AlienEncounter;
import spacesurvival.EnergyCalculator;
import spacesurvival.EnergyEventIdea;
import spacesurvival.SpaceStationVisit;
import testutil.AbstractTest;

@SuppressWarnings("unused")
public class EnergyCalculatorTest extends AbstractTest {

	//--------------------------
	//Main (Entry Point)

	public static void main(String[] args) {
		EnergyCalculatorTest test = new EnergyCalculatorTest();
		test.testNoEnergySources();
		test.testOneAlienEncouter();
		test.testAlienAndSpaceStation();
		test.testManyEnergies();
		test.printSummary();
	}

	//--------------------------
	//Test Data

	private List<EnergyEventIdea> sourcesFrom(int[] alienEnergies, int[] spaceStationEnergies) {
		//Testing convenience helper		
		//Return list of energy sources from the energy value params

		//TODO -- optional -- convenient for calculator construction
		//construct new list of type "EnergyEventIdea", then populate list
		//with method input data (params) i.e. by constructing proper objects
		//and adding to new list
		//return resulting list

		return null;
	}

	private int[] nums(int... args) {
		//Testing convenience helper		
		int[] a = new int[args.length];
		for (int i = 0; i < args.length; i++)
			a[i] = args[i];
		return a;
	}

	//--------------------------
	//Tests

	private void testNoEnergySources() {
		header("Starting -- testNoEnergySources");
		//1-2-3 declare, construct, execute

		List<EnergyEventIdea> emptyList = Collections.emptyList();
		EnergyCalculator calculator = new EnergyCalculator(emptyList);
		calculator.compute();

		//Test
		int expectedTotalEnergy = 0;

		assertEquals(expectedTotalEnergy, calculator.getTotalEnergy());
	}

	private void testOneAlienEncouter() {
		header("Starting -- testOneAlienEncouter");
		//One alien encounter with energy 8
		List<EnergyEventIdea> al = new ArrayList<>();
		AlienEncounter ae = new AlienEncounter(8);
		al.add(ae);

		EnergyCalculator calculator = new EnergyCalculator(al);
		calculator.compute();
		int expectedTotalEnergy = 8;

		//Test
		assertEquals(expectedTotalEnergy, calculator.getTotalEnergy());
	}

	private void testAlienAndSpaceStation() {
		header("Starting -- testAlienAndSpaceStation");
		List<EnergyEventIdea> al = new ArrayList<>();
		AlienEncounter ae = new AlienEncounter(-9);
		SpaceStationVisit sp = new SpaceStationVisit(5);
		al.add(ae);
		al.add(sp);

		EnergyCalculator calculator = new EnergyCalculator(al);
		calculator.compute();

		//Test
		int expectedTotalEnergy = -9 + 5;
		assertEquals(expectedTotalEnergy, calculator.getTotalEnergy());
	}

	private void testManyEnergies() {
		header("Starting -- testManyEnergies");
		List<EnergyEventIdea> al = new ArrayList<>();
		int n = -4;
		int m = 10;

		for (int i = 0; i < 4; i++) {
			AlienEncounter ae = new AlienEncounter(n);
			al.add(ae);
			n++;
		}

		for (int j = 0; j < 2; j++) {
			SpaceStationVisit sp = new SpaceStationVisit(m);
			al.add(sp);
			m = m/2;
		}

		EnergyCalculator calculator = new EnergyCalculator(al);
		calculator.compute();

		//Test
		int expectedTotalEnergy = -4 - 3 - 2 - 1 + 10 + 5;
		assertEquals(expectedTotalEnergy, calculator.getTotalEnergy());
	}

}