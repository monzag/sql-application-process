public class Application {

    private View view = new View();
    private SQLiteJDBC sqlite = new SQLiteJDBC();

    public static final int MENTORS_BY_FULL_NAME = 1;
    public static final int MENTORS_BY_CITY = 2;
    public static final int ADD_NEW_COLUMN = 3;
    public static final int ADD_DATA_TO_NEW_COLUMN = 4;
    public static final int ADD_NEW_APPLICANT = 5;
    public static final int UPDATE_APPLICANT = 6;
    public static final int DELETE_APPLICANT = 7;
    public static final int ADVANCED_SEARCH = 8;

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        view.displayMenu();
        int userChoice = view.getUserChoice();

        switch(userChoice) {
            case MENTORS_BY_FULL_NAME: displayMentorsByFullname();
                break;
            case MENTORS_BY_CITY: displayMentorsByCity();
                break;
            case ADD_NEW_COLUMN: addNewColumnFullName();
                break;
            case ADD_DATA_TO_NEW_COLUMN: addFullnameByEmail();
                break;
            case ADD_NEW_APPLICANT: addNewApplicant();
                break;
            case UPDATE_APPLICANT: updatePhone();
                break;
            case DELETE_APPLICANT: deleteApplicant();
                break;
        }
    }

    public void displayMentorsByFullname() {;
        sqlite.selectByFullName();;
    }

    public void displayMentorsByCity() {
        sqlite.selectByCity();
    }

    public void addNewColumnFullName() {
        sqlite.addColumn();
        sqlite.updateFullnameByName();
    }

    public void addFullnameByEmail() {
        sqlite.updateFullnameByEmail();
    }

    public void addNewApplicant() {
        sqlite.addNewApplicant();
    }

    public void updatePhone() {
        sqlite.updatePhoneByName();
    }

    public void deleteApplicant() {
        sqlite.deleteApplicant();
    }
}