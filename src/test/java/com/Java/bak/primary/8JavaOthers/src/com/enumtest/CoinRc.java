package com.enumtest;

public enum Coin {
	penny("fenqian"),nickel("5fenyingbi"),dime("1jiaoyingbi"),quarter("2jiao5fen");
	private String value;
	Coin(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
	public static void main(String[] args)
	{
		Coin coin=Coin.quarter;
		System.out.println(coin.getValue());
	}
}
