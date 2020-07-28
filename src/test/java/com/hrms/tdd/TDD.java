package com.hrms.tdd;

import org.testng.annotations.Test;

public class TDD {
@Test
public void knockingDoor() {
	System.out.println("Someone is knocking on the door");

}
@Test(dependsOnMethods= {"knocking Door"})
public void openingDoor1() {
	System.out.println("I will open the door but only because someone knocked");
}
@Test(dependsOnMethods= {"openingDoor"})
public void openingDoor() {
	System.out.println("I closed the door after opening the door to whoever knocked");
}
}