package youtLambda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StreamApiDemo {

	public void runSample() {
		System.out.println("runSample()");
		List<Specialist> specialistOld = OldApproachUtil.getSpecialstsOld();
		List<Specialist> specialistStream = StreamApiUtil.getSpecialistsStream();
		StreamApiUtil.printStream(specialistOld);
		StreamApiUtil.printStream(specialistStream);
		
		List<Specialist> engineerOld = OldApproachUtil.filterBySpecialityOld(specialistOld, Specialty.ENGINEER);
		List<Specialist> engineerStream = StreamApiUtil.filterBySpecialityStream(specialistStream, Specialty.ENGINEER);
		StreamApiUtil.printStream(engineerOld);
		StreamApiUtil.printStream(engineerStream);
		
		List<Specialist> sortListStreamAsc = StreamApiUtil.sortSpecialistByNameAsc(specialistStream);
		List<Specialist> sortListStreamDesc = StreamApiUtil.sortSpecialistByNameDesc(specialistStream);
		StreamApiUtil.printStream(sortListStreamAsc);
		StreamApiUtil.printStream(sortListStreamDesc);
		
		Specialist maxSalarySpec = StreamApiUtil.findWithMaxSalary(specialistStream);
		Specialist minSalarySpec = StreamApiUtil.findWithMinSalary(specialistStream);
		System.out.println("maxSalarySpec:: " + maxSalarySpec);
		System.out.println("minSalarySpec:: " + minSalarySpec);
		
		Map<Specialty, List<Specialist>> mapGroup = StreamApiUtil.groupBySpeciality(specialistStream);
		
		boolean matchAllEngineerOld = OldApproachUtil.matchAllEngineerOld(specialistOld);
		boolean matchAllEngineerStream = StreamApiUtil.matchAllEngineerStream(specialistStream);
		System.out.println("matchAllEngineerOld:: " + matchAllEngineerOld);
		System.out.println("matchAllEngineerStream:: " + matchAllEngineerStream);
		
		boolean matchAnyEngineerOld = OldApproachUtil.matchAnyEngineerOld(specialistOld);
		boolean matchAnyEngineerStream = StreamApiUtil.matchAnyEngineerStream(specialistStream);
		System.out.println("matchAnyEngineerOld:: " + matchAnyEngineerOld);
		System.out.println("matchAnyEngineerStream:: " + matchAnyEngineerStream);
		
		boolean matchNoneSalaryMoreThenOld = OldApproachUtil.matchNoneSalaryMoreThenOld(specialistStream, new BigDecimal(100000));
		boolean matchNoneSalaryMoreThenStream = StreamApiUtil.matchNoneSalaryMoreThenStream(specialistStream, new BigDecimal(100000));
		System.out.println("matchNoneSalaryMoreThenOld:: " + matchNoneSalaryMoreThenOld);
		System.out.println("matchNoneSalaryMoreThenStream:: " + matchNoneSalaryMoreThenStream);
	}
	
}
