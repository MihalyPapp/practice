package com.mihalypapp.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MatrixMul {

	private static int[][] MatrixMultiplySingleThread(int[][] m1, int[][] m2) {
		assert m1[0].length == m2.length;
		int l = m1.length;
		int m = m1[0].length;
		int n = m2[0].length;
		int[][] m3 = new int[l][n];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return m3;
	}

	private static int[][] MatrixMultiplyMultiThread(int[][] m1, int[][] m2) throws InterruptedException {
		final int l = m1.length;
		final int m = m2.length;
		final int n = m2[0].length;
		int[][] m3 = new int[l][n];
		List<Thread> threads = new ArrayList<>();
		final int threadCount = 8;
		final int chunkSize = (l + threadCount - 1) / threadCount;

		for (int chunk = 0; chunk < threadCount; chunk++) {
			final int _chunk = chunk;
			Thread thread = new Thread(() -> {
				final int iMax = Math.min(l, (_chunk + 1) * chunkSize);
				for (int i = _chunk * chunkSize; i < iMax; i++) {
					for (int j = 0; j < n; j++) {
						int sum = 0;
						for (int k = 0; k < m; k++) {
							sum += m1[i][k] * m2[k][j];
						}
						m3[i][j] = sum;
					}
				}
			});
			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.join();
		}

		return m3;
	}
	
	private static int[][] MatrixMultiply_L_N_Thread(int[][] m1, int[][] m2) throws InterruptedException {
		assert m1[0].length == m2.length;
		int l = m1.length;
		int m = m1[0].length;
		int n = m2[0].length;
		int[][] m3 = new int[l][n];
		Thread[] threads = new Thread[l * n];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				final int ii = i;
				final int jj = j;
				threads[i * n + j] = new Thread(() -> {
					for (int k = 0; k < m; k++) {
						m3[ii][jj] += m1[ii][k] * m2[k][jj];
					}
				});
				threads[i * n + j].start();
			}
		}
		for (int i = 0; i < threads.length; i++)
			threads[i].join();
		return m3;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// int[][] m1 = { { 1, 2, 3}, {3, 2, 1} };
		// int[][] m2 = { { 1, 2}, {3, 2}, {4, 5} };
		int[][] m1 = new int[1000][400];
		int[][] m2 = new int[400][1000];
		
		long start = System.currentTimeMillis();
		MatrixMultiplySingleThread(m1, m2);
		long finish = System.currentTimeMillis();
		System.out.println(finish - start);

		start = System.currentTimeMillis();
		MatrixMultiplyMultiThread(m1, m2);
		finish = System.currentTimeMillis();
		System.out.println(finish - start);

		start = System.currentTimeMillis();
		MatrixMultiply_L_N_Thread(m1, m2);
		finish = System.currentTimeMillis();
		System.out.println(finish - start);
	}

}
