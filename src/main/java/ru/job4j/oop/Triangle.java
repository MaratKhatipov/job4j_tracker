package ru.job4j.oop;

public class Triangle {
	private Point first;
	private Point second;
	private Point third;

	public Triangle(Point aPoint, Point bPoint, Point cPoint) {
		this.first = aPoint;
		this.second = bPoint;
		this.third = cPoint;
	}

	public double halfPeriod(double a, double b, double c) {
		return (a + b + c) / 2;
	}

	public boolean exist(double ab, double bc, double ca) {
		return (ab + bc > ca) && (ab + ca > bc) && (bc + ca > ab);
	}

	public double area() {
		double rsl = -1;
		double ab = first.distance(second);
		double ac = first.distance(third);
		double bc = second.distance(third);
		double p = halfPeriod(ab, bc, ac);
		if (this.exist(ab, bc, ac)) {
			double tmp = p * (p - ab) * (p - bc) * (p - ac);
			rsl = Math.sqrt(tmp);
		}
		return rsl;
	}
}
