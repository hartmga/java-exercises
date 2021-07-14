package com.hcl.java8.ex6;

import java.util.AbstractMap;
import java.util.Arrays;

/*
6.	(Manipulating a Stream<Invoice>) Create the class Invoice described with the information below and
then create an array of Invoice objects. Use the sample data shown in Fig. 1. Class Invoice includes four
instance variables—a partNumber (type String), a part-Description (type String), a quantity of the item
being purchased (type int) and a pricePerItem (type double) and corresponding get methods. Perform the
following queries on the array of Invoice objects and display the results:
 */
public class Exercise6 {

	public static void main(String[] args) {
		// create the array of Invoices
		Invoice[] invoices = new Invoice[] { new Invoice("83", "Electric sander", 7, 300),
				new Invoice("24", "Power saw", 18, 167), new Invoice("7", "Sledge hammer", 11, 56),
				new Invoice("77", "Hammer", 76, 25), new Invoice("39", "Lawn Mower", 3, 750),
				new Invoice("68", "Screwdriver", 106, 7), new Invoice("56", "Jig saw", 21, 48),
				new Invoice("3", "Wrench", 34, 14) };
		// 1. Use streams to sort the Invoice objects by partDescription, then display
		// the results.
		Arrays.stream(invoices).sorted((a, b) -> a.getPartDescription().compareTo(b.getPartDescription()))
				.forEach(System.out::println);
		System.out.println();

		// 2. Use streams to sort the Invoice objects by pricePerItem, then display the
		// results.
		Arrays.stream(invoices).sorted((a, b) -> Double.compare(a.getPricePerItem(), b.getPricePerItem()))
				.forEach(System.out::println);
		System.out.println();

		// 3. Use streams to map each Invoice to its partDescription and quantity, sort
		// the results by quantity, then display the results.
		Arrays.stream(invoices)
				.map(i -> new AbstractMap.SimpleEntry<String, Integer>(i.getPartDescription(), i.getQuantity()))
				.sorted((a, b) -> a.getValue() - b.getValue()).forEach(System.out::println);
		// AbstractMap.SimpleEntry seemed like the best way to represent the
		// (description, quantity) pair, although this is not the intended purpose of
		// the class
		System.out.println();

		// 4. Use streams to map each Invoice to its partDescription and the value of
		// the Invoice (i.e., quantity * pricePerItem). Order the results by Invoice
		// value.
		Arrays.stream(invoices)
				.map(i -> new AbstractMap.SimpleEntry<>(i.getPartDescription(), i.getQuantity() * i.getPricePerItem()))
				.sorted((a, b) -> Double.compare(a.getValue(), b.getValue())).forEach(System.out::println);
		System.out.println();

		// 5. Modify Part (d) to select the Invoice values in the range $200 to $500.
		Arrays.stream(invoices)
				.map(i -> new AbstractMap.SimpleEntry<>(i.getPartDescription(), i.getQuantity() * i.getPricePerItem()))
				.filter(a -> a.getValue() >= 200 && a.getValue() <= 500)
				.sorted((a, b) -> Double.compare(a.getValue(), b.getValue())).forEach(System.out::println);
		System.out.println();

		// 6. Find any one Invoice in which the partDescription contains the word "saw".
		Invoice saw = Arrays.stream(invoices).filter((i) -> i.getPartDescription().toLowerCase().contains("saw"))
				.findAny().orElse(null);
		System.out.println(saw);

	}

}
