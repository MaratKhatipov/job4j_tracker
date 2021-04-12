package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapason {
	List<Double> diapason(int start, int end, Function<Double, Double> func) {
		List<Double> result = new ArrayList<>();
		for (int i = start; i < end; i++) {
			/*
			double value = i;
			Вопрос: как лучше сделать, подставить значение value
			или оставить каст?
			*/
			result.add(func.apply((double) i));
		}
		return result;
	}
}
