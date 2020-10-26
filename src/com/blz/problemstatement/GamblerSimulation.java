package com.blz.problemstatement;

import java.util.Random;

public class GamblerSimulation {
	static int stake = 100;
	static int bet = 1;
	static int money = 0;

	// UC1
	public static void initialMoney() {
		System.out.println("Stake_Amount:" + stake);
	}

	// UC2
	public static void startBetting() {
		Random genrate = new Random();
		int number = genrate.nextInt(2);
		if (number == 1) {
			money = money + 1;
			System.out.println("Won the Game");
		} else {
			money = money - 1;
			System.out.println("Loss the Game");
		}
	}

	public static void main(String[] args) {
		startBetting();
	}
}
