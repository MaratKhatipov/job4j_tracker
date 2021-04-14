package ru.job4j.stream;

public class BusinessBuildTest {
	private String companyName;
	private String companyIndustry;
	private String companyLocation;
	private int amountEmployee;
	private double averageSalary;
	private double incomeCompany;
	private double costs;

	@Override
	public String toString() {
		return "BusinessBuildTest{"
				+ "companyName='" + companyName
				+ '\'' + ", companyIndustry='" + companyIndustry
				+ '\'' + ", companyLocation='" + companyLocation
				+ '\'' + ", amountEmployee=" + amountEmployee
				+ ", averageSalary=" + averageSalary
				+ ", incomeCompany=" + incomeCompany
				+ ", costs=" + costs
				+ '}';
	}

	static class Builder {
		private String companyName;
		private String companyIndustry;
		private String companyLocation;
		private int amountEmployee;
		private double averageSalary;
		private double incomeCompany;
		private double costs;

		Builder buildCompanyName(String companyName) {
			this.companyName = companyName;
			return this;
		}

		Builder buildCompanyIndustry(String companyIndustry) {
			this.companyIndustry = companyIndustry;
			return this;
		}

		Builder buildCompanyLocation(String companyLocation) {
			this.companyLocation = companyLocation;
			return this;
		}

		Builder buildAmountEmployee(int amountEmployee) {
			this.amountEmployee = amountEmployee;
			return this;
		}

		Builder buildAverageSalary(double averageSalary) {
			this.averageSalary = averageSalary;
			return this;
		}

		Builder buildIncomeCompany(double incomeCompany) {
			this.incomeCompany = incomeCompany;
			return this;
		}

		Builder buildCosts(double costs) {
			this.costs = costs;
			return this;
		}

		BusinessBuildTest build() {
			BusinessBuildTest business = new BusinessBuildTest();
			business.companyName = companyName;
			business.companyIndustry = companyIndustry;
			business.companyLocation = companyLocation;
			business.amountEmployee = amountEmployee;
			business.averageSalary = averageSalary;
			business.incomeCompany = incomeCompany;
			business.costs = costs;
			return business;
		}
	}

	public static void main(String[] args) {
		BusinessBuildTest business = new Builder()
				.buildCompanyName("Horns and Hooves")
				.buildCompanyIndustry("Energy ")
				.buildCompanyLocation("NY")
				.buildAmountEmployee(100)
				.buildIncomeCompany(1000000.8)
				.buildAverageSalary(120.6)
				.buildCosts(4568.96)
				.build();
		System.out.println(business);
	}
}
