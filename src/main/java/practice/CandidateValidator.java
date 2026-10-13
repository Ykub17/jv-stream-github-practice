package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int totalYearsInUkr = 0;
        String[] periods = candidate.getPeriodsInUkr().split(",");
        for (String period : periods) {
            String[] years = period.trim().split("-");
            totalYearsInUkr += Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        }

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && totalYearsInUkr >= 10;
    }
}
