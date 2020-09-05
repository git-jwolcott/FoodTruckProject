package com.skilldistillery.foodproject;

public class FoodTruck {
	private int truckId;
	private String truckName;
	private String foodType;
	private int truckRating;
	
	private static int nextTruckId = 1;
	
	//create a truck and auto generate and assign it's truck number
	public FoodTruck(String truckName, String foodType, int truckRating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.truckId = nextTruckId;
		
		//increment nextTruckId for the next truck
		nextTruckId += 1;
	}
	
	
	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}
	
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public int getTruckRating() {
		return truckRating;
	}
	
	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}
	
	 public String toString() {
		    String output = "Truck Name: " + truckName + ", TruckId: " + truckId + ", Food type: " + foodType + ", Rating: " + truckRating;
		    return output;
		  }
	
	 public void displayTruck() {
		    String truckData = this.toString();
		    System.out.println(truckData);
		  }
	
}
