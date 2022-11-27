package pro.sky.java.course2.examinerservice.controller;

import pro.sky.java.course2.examinerservice.domain.Question;

public class Constants {
    public static final String JAVA_QUESTION_1 = "JavaQuestion1";
    public static final String JAVA_QUESTION_2 = "JavaQuestion2";
    public static final String JAVA_QUESTION_3 = "JavaQuestion3";
    public static final String JAVA_QUESTION_4 = "JavaQuestion4";
    public static final String JAVA_QUESTION_5 = "JavaQuestion5";
    public static final String JAVA_ANSWER_1 = "JavaAnswer1";
    public static final String JAVA_ANSWER_2 = "JavaAnswer2";
    public static final String JAVA_ANSWER_3 = "JavaAnswer3";
    public static final String JAVA_ANSWER_4 = "JavaAnswer4";
    public static final String JAVA_ANSWER_5 = "JavaAnswer5";
    public static final String MATH_QUESTION_1 = "MathQuestion1";
    public static final String MATH_QUESTION_2 = "MathQuestion2";
    public static final String MATH_QUESTION_3 = "MathQuestion3";
    public static final String MATH_QUESTION_4 = "MathQuestion4";
    public static final String MATH_QUESTION_5 = "MathQuestion5";
    public static final String MATH_ANSWER_1 = "MathAnswer1";
    public static final String MATH_ANSWER_2 = "MathAnswer2";
    public static final String MATH_ANSWER_3 = "MathAnswer3";
    public static final String MATH_ANSWER_4 = "MathAnswer4";
    public static final String MATH_ANSWER_5 = "MathAnswer5";


    public static Question JAVA_OBJ_QUESTION_1 = new Question(JAVA_QUESTION_1, JAVA_ANSWER_1);
    public static Question JAVA_OBJ_QUESTION_2 = new Question(JAVA_QUESTION_2, JAVA_ANSWER_2);
    public static Question JAVA_OBJ_QUESTION_3 = new Question(JAVA_QUESTION_3, JAVA_ANSWER_3);
    public static Question JAVA_OBJ_QUESTION_4 = new Question(JAVA_QUESTION_4, JAVA_ANSWER_4);
    public static Question JAVA_OBJ_QUESTION_5 = new Question(JAVA_QUESTION_5, JAVA_ANSWER_5);

    public static Question MATH_OBJ_QUESTION_1 = new Question(MATH_QUESTION_1, MATH_ANSWER_1);
    public static Question MATH_OBJ_QUESTION_2 = new Question(MATH_QUESTION_2, MATH_ANSWER_2);
    public static Question MATH_OBJ_QUESTION_3 = new Question(MATH_QUESTION_3, JAVA_ANSWER_3);
    public static Question MATH_OBJ_QUESTION_4 = new Question(MATH_QUESTION_4, JAVA_ANSWER_4);
    public static Question MATH_OBJ_QUESTION_5 = new Question(MATH_QUESTION_5, JAVA_ANSWER_5);

}
