package youtLambda;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiUtil {

	//создание списка специалистов
	public static List<Specialist> getSpecialistsStream() {
		return List.of(new Specialist("AAA", new BigDecimal(1000), Specialty.ENGINEER),
						new Specialist("BBB", new BigDecimal(2000), Specialty.DEVOPS),
						new Specialist("CCC", new BigDecimal(5000), Specialty.MANAGER),
						new Specialist("DDD", new BigDecimal(3000), Specialty.ENGINEER),
						new Specialist("EEE", new BigDecimal(10000), Specialty.ENGINEER));
	}
	
	//создание списка специалистов определенной специальности
	public static List<Specialist> filterBySpecialityStream(List<Specialist> specialists, Specialty specialty) {
		return specialists.stream()
							.filter(specialist -> specialist.getSpecialty().equals(specialty))
							.collect(Collectors.toList());
	}
	
	//создание сортированного списка (по имени) специалистов
	public static List<Specialist> sortSpecialistByNameAsc(List<Specialist> specialists) {
		return specialists.stream()
							.sorted(Comparator.comparing(Specialist::getName))
							.collect(Collectors.toList());
	}
	
	//создание сортированного списка (по имени) специалистов по убыванию
	public static List<Specialist> sortSpecialistByNameDesc(List<Specialist> specialists) {
		return specialists.stream()
							.sorted(Comparator.comparing(Specialist::getName).reversed())
							.collect(Collectors.toList());
	}
	
	//поиск специалиста с максимальной оплатой
	public static Specialist findWithMaxSalary(List<Specialist> specialists) {
		return specialists.stream()
							.max(Comparator.comparing(Specialist::getSalary))
							.orElse(null);
				
	}
	
	//поиск специалиста с минимальной оплатой
	public static Specialist findWithMinSalary(List<Specialist> specialists) {
		return specialists.stream()
							.min(Comparator.comparing(Specialist::getSalary))
							.orElse(null);
	}
	
	//построение сгруппированного по профессии списка специалистов
	public static Map<Specialty, List<Specialist>> groupBySpeciality(List<Specialist> specialists) {
		return specialists.stream()
							.collect(Collectors.groupingBy(Specialist::getSpecialty));
	}
	
	//проверяем все ли специалисты - инженеры
	public static boolean matchAllEngineerStream(List<Specialist> specialists) {
		return specialists.stream()
							.allMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
	}
	
	//проверяем есть ли хоть один специалист - инженер
	public static boolean matchAnyEngineerStream(List<Specialist> specialists) {
		return specialists.stream()
							.anyMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
	}
	
	//проверяем что никто не имеет оплаты выше чем представленная
	public static boolean matchNoneSalaryMoreThenStream(List<Specialist> specialists, BigDecimal salary) {
		return specialists.stream()
							.noneMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
	}
	
	public static void printStream(List<Specialist> specialists) {
		System.out.println("###################################");
		specialists.stream().forEach(System.out::println);
	}
}
