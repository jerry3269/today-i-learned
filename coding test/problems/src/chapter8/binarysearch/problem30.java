package chapter8.binarysearch;

import java.util.*;
import java.util.stream.Collectors;

public class problem30 {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        int[] solution = solution(info, query);
        System.out.println(Arrays.toString(solution));
    }

    private static List<Applicant> applicantList = new ArrayList<>();
    private static List<Integer> answer = new ArrayList<>();
    private static Map<String, List<Applicant>> storage = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        for (String applicantInfo : info) {
            saveApplicantInfo(applicantInfo);
        }

        applicantList.sort(Comparator.comparing(Applicant::getScore));

        for (String queryInfo : query) {
            int count = getCountByQuery(queryInfo);
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getCountByQuery(String queryInfo) {

        String replaceQueryInfo = queryInfo.replace(" and", "");
        String[] queryToken = replaceQueryInfo.split(" ");
        String key = queryToken[0] + queryToken[1] + queryToken[2] + queryToken[3];

        if (storage.get(key) != null) {
            return binarySearch(storage.get(key), Integer.parseInt(queryToken[4]));
        }

        List<Applicant> selectedList = applicantList.stream()
                .filter(applicant -> {
                    return (applicant.isLanguage(queryToken[0]) &&
                            applicant.isOccupation(queryToken[1]) &&
                            applicant.isCareer(queryToken[2]) &&
                            applicant.isSoulFood(queryToken[3]));
                })
                .collect(Collectors.toList());

        storage.put(key, selectedList);

        return binarySearch(selectedList, Integer.parseInt(queryToken[4]));
    }

    private static void saveApplicantInfo(String applicantInfo) {
        String[] split = applicantInfo.split(" ");
        Applicant applicant = new Applicant(Arrays.asList(split));
        applicantList.add(applicant);
    }

    private static int binarySearch(List<Applicant> applicantList, int score) {
        if (applicantList.isEmpty()) {
            return 0;
        }

        int start = 0;
        int end = applicantList.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (applicantList.get(mid).getScore() >= score) {
                end = mid;
            } else{
                start = mid + 1;
            }
        }

        if (applicantList.get(start).getScore() < score) {
            return applicantList.size() - start - 1;
        }

        return applicantList.size() - start;
    }


    private static class Applicant{
        private Language language;
        private Occupation occupation;
        private Career career;
        private SoulFood soulFood;
        private int score;

        public Applicant(List<String> applicantInfoList) {
            this.language = Language.valueOf(applicantInfoList.get(0));
            this.occupation = Occupation.valueOf(applicantInfoList.get(1));
            this.career = Career.valueOf(applicantInfoList.get(2));
            this.soulFood = SoulFood.valueOf(applicantInfoList.get(3));
            this.score = Integer.parseInt(applicantInfoList.get(4));
        }

        public int getScore() {
            return score;
        }

        public boolean isLanguage(String language) {
            if(language.equals("-")) return true;
            return this.language.name().equals(language);
        }

        public boolean isOccupation(String occupation) {
            if(occupation.equals("-")) return true;
            return this.occupation.name().equals(occupation);
        }

        public boolean isCareer(String career) {
            if(career.equals("-")) return true;
            return this.career.name().equals(career);
        }

        public boolean isSoulFood(String soulFood) {
            if(soulFood.equals("-")) return true;
            return this.soulFood.name().equals(soulFood);
        }
    }

    private enum Language{
        java,
        python,
        cpp;
    }

    private enum Occupation{
        backend,
        frontend;
    }

    private enum Career{
        junior,
        senior;
    }

    private enum SoulFood{
        pizza,
        chicken;
    }
}
