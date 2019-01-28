package com.an.analytical;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
	static private Map<String, List<Double>> statsMap = new HashMap<>();

	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		@Override
		public void putNewPrice(String symbol, double price) {

			List<Double> priceList = new ArrayList<>();

			if (statsMap.get(symbol) != null) {
				priceList = statsMap.get(symbol);
				priceList.add(price);
				statsMap.put(symbol, priceList);
			} else {
				priceList.add(price);
				statsMap.put(symbol, priceList);
			}

		}

		@Override
		public double getAveragePrice(String symbol) {
			double averagePrice = 0, sumPrice = 0;
			List<Double> priceList = new ArrayList<>();
			if (statsMap.get(symbol) != null) {
				priceList = statsMap.get(symbol);
				for (double price : priceList) {

					sumPrice += price;
				}
				averagePrice = sumPrice / (priceList.size());
			}

			return averagePrice;
		}

		@Override
		public int getTickCount(String symbol) {
			int count = 0;

			if (statsMap.get(symbol) != null) {
				List<Double> priceList = statsMap.get(symbol);
				count = priceList.size();
			}
			return count;
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}
