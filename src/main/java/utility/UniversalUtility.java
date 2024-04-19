package utility;

import data.FormOfEducation;
import data.Semester;

import java.util.HashMap;
import java.util.Map;

public class UniversalUtility {
    public static String CommandFormat(String command) {
        return command.replaceAll("(?!^)([A-Z])", "_$1").toLowerCase();
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