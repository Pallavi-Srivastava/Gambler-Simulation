package com.blz.problemstatement;

import java.util.Random;

public class GamblerSimulation {
	static int stake = 100;
	static int bet = 1;
	static int money = 0;
	static int winingCondition, lossingCodition = 0;
	static int amountEarn = 0;

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
			// System.out.println("Won the Game");
		} else {
			money = money - 1;
			// System.out.println("Loss the Game");
		}
	}

	// UC3
	public int stopGame(int day) {
		winingCondition = (int) Math.round(stake + (stake * 0.5));
		lossingCodition = (int) Math.round(stake * 0.5);
		money = stake;
		boolean endGame = true;
		while (endGame == true) {
			startBetting();
			if (money == winingCondition) {
				// System.out.println("Stake_Value in WinningCondition :" + money);
				endGame = false;
			}
			if (money == lossingCodition) {
				// System.out.println("Stake_Value in LossingCondition : " + money);
				endGame = false;
			}
		}
		return money;
	}

	// UC4
	public int totalAmount() {
		int totalDay = 20;
		int day = 0;
		int stakeValue = 0;
		while (totalDay > 0) {
			day++;
			stakeValue = stopGame(day);
			totalDay = totalDay - 1;
			amountEarn = amountEarn + stakeValue;
		}
		return amountEarn;
	}

	// UC5
	public void monthlyCalculation() {
		System.out.println("MonthlyEarning : " + totalAmount());
	}

	public static void main(String[] args) {
		GamblerSimulation sm = new GamblerSimulation();
		sm.monthlyCalculation();
	}
}
