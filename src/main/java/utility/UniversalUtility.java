package utility;

import data.FormOfEducation;
import data.Semester;

import java.util.HashMap;
import java.util.Map;

public class UniversalUtility {
    public static String CommandFormat(String userInput) {
        String[] userInputList = userInput.split("_");
        String userCommand = "";
        for (String string : userInputList) {
            String partOfCommandName = string.substring(0, 1).toUpperCase() + string.substring(1);
            userCommand += partOfCommandName;
        }
        return userCommand;
    }
    private static final Map<String, Semester> mapSemester;
    static {
        mapSemester = new HashMap<String, Semester>();
        for (Semester v : Semester.values()) {
            mapSemester.put(v.name, v);
        }
    }
    private static final Map<String, FormOfEducation> mapFormOfEducation;
    static {
        mapFormOfEducation = new HashMap<String, FormOfEducation>();
        for (FormOfEducation v : FormOfEducation.values()) {
            mapFormOfEducation.put(v.name, v);
        }
    }
    public static Semester findSemesterByKey(String i) {
        return mapSemester.get(i);
    }
    public static FormOfEducation findFormOfEducationByKey(String i) {
        return mapFormOfEducation.get(i);
    }
}