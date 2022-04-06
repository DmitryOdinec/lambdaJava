package youtLambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldApproachUtil {

	//create List specialst
	public static List<Specialist> getSpecialstsOld() {
		List<Specialist> result = new ArrayList<Specialist>();
		result.add(new Specialist("AAA", new BigDecimal(1000), Specialty.ENGINEER));
		result.add(new Specialist("BBB", new BigDecimal(2000), Specialty.DEVOPS));
		result.add(new Specialist("CCC", new BigDecimal(5000), Specialty.MANAGER));
		result.add(new Specialist("DDD", new BigDecimal(3000), Specialty.ENGINEER));
		result.add(new Specialist("EEE", new BigDecimal(10000), Specialty.ENGINEER));
		return result;
	}
	
	public static List<Specialist> filterBySpecialityOld(List<Specialist> specialists, Specialty specialty) {
		List<Specialist> result = new ArrayList<Specialist>();
		for(int i = 0; i < specialists.size(); i++) {
			if(specialists.get(i).getSpecialty().equals(specialty)) {
				result.add(specialists.get(i));
			}
		}
		return result;
	}
	
	public static boolean matchAllEngineerOld(List<Specialist> specialists) {
		boolean result = false;
		for(int i = 0; i < specialists.size(); i++) {
			if(!specialists.get(i).getSpecialty().equals(Specialty.ENGINEER)) {
				return result;
			}
		}
		result = true;
		return result;
	}
	
	public static boolean matchAnyEngineerOld(List<Specialist> specialists) {
		boolean result = false;
		for(int i = 0; i < specialists.size(); i++) {
			if(specialists.get(i).getSpecialty().equals(Specialty.ENGINEER)) {
				return result = true;
			}
		}
		return result;
	}
	
	public static boolean matchNoneSalaryMoreThenOld(List<Specialist> specialists, BigDecimal salary) {
		boolean result = false;
		for(int i = 0; i < specialists.size(); i++) {
			if(specialists.get(i).getSalary().compareTo(salary) > 0) {
				return result;
			}
		}
		result = true;
		return result;
	}
}
