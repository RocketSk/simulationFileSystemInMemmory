import java.util.Scanner;

public class UserInput {
    private static final String REGEX_SPLIT = "/";
    private static final String ROOT = "root";
    private static final String STOP = "stop";
    private static final String SAVE = "save";
    private static final String LOAD = "load";
    private static final String ACTION_POINTER = "\nPlease input directory: \n";
    private static final String EXCEPTION_MESSAGE = "Please use root folder or other command";
    private static final String GREETING_MESSAGE = ("If you want to add new data to System, please, use : \n"
            + "\"root/...\" how rooted package. \n"
            + "For saving or loading you last save, please use \"save\" or \"load\" \n"
            + "When you want stopped program please input \"stop\" only.");

    static {
        System.out.println(GREETING_MESSAGE);
    }

    private final Scanner sc = new Scanner(System.in);

    private String[] splittingString() {
        System.out.println(ACTION_POINTER);
        String[] userInputArray = sc.nextLine().split(REGEX_SPLIT);
        System.out.println();
        if (userInputArray[0].equals(ROOT)
                || (userInputArray.length == 1
                && userInputArray[0].equals(STOP)
                || userInputArray[0].equals(SAVE)
                || userInputArray[0].equals(LOAD))) {
            return userInputArray;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public String[] getTextArray() {
        return splittingString();
    }
}