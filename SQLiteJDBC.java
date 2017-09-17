import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteJDBC {

    public void selectByFullName() {
        String path = "jdbc:sqlite:mentors.db";
        String query = "SELECT first_name, last_name FROM mentors;";
        select_db(path, query);
    }

    public void selectByCity() {
        Connection connect = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:mentors.db");
            connect.setAutoCommit(false);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT nick_name FROM mentors WHERE city='''Miskolc''';");

            while (resultSet.next()) {
                String nick_name = resultSet.getString("nick_name");

                System.out.println(nick_name);
            }

            resultSet.close();
            statement.close();
            connect.close();

        } catch (Exception e) {
            System.out.print("Try again");
            System.exit(0);
        }

        System.out.println("Select work!");
    }

    public void addColumn() {
        String path = "jdbc:sqlite:applicants.db";
        String sql_command = "ALTER TABLE applicants ADD full_name;";
        change_db(path, sql_command);
        System.out.println("Good job - you add new column!");
    }

    public void updateFullnameByName() {
        String path = "jdbc:sqlite:applicants.db";
        String sql_command = "UPDATE applicants SET full_name = first_name || ' ' || last_name WHERE first_name='Carol';";
        updateApplicant(path, sql_command);
    }

    public void updateFullnameByEmail() {
        String path = "jdbc:sqlite:applicants.db";
        String sql_command = "UPDATE applicants SET full_name = first_name || ' ' || last_name WHERE email LIKE '%@adipiscingenimmi.edu';";
        updateApplicant(path, sql_command);
    }

    public void addNewApplicant() {
        String path = "jdbc:sqlite:applicants.db";
        String sql_command = "INSERT INTO applicants (first_name, last_name, phone_number, email, application_code)" +
                             "VALUES ('Markus', 'Kowalski', '003620/725-2666', 'djnovus@groovecoverage.com', 54823);";

        change_db(path, sql_command);
        System.out.println("Good job - you insert new Marcus");
        selectApplicants();
    }

    public void selectApplicants() {
        String path = "jdbc:sqlite:applicants.db";
        String query = "SELECT first_name, last_name FROM applicants;";
        select_db(path, query);
    }

    public void updatePhoneByName() {
        String path = "jdbc:sqlite:applicants.db";
        String sql_command = "UPDATE applicants SET phone_number = '003670/223-7000'" + 
                             "WHERE first_name = '''Jemima''' AND last_name = '''Foreman''';";
        updateApplicant(path, sql_command);
    }

    public void updateApplicant(String path, String sql_command) {
        change_db(path, sql_command);
        System.out.println("Update done");
    }

    public void deleteApplicant() {
        String path = "jdbc:sqlite:applicants.db";
        String sql_command = "DELETE FROM applicants WHERE email LIKE '%arcu.co.uk%';";
        change_db(path, sql_command);

        System.out.println("Delete Applicant");
    }

    public void change_db(String path,String sql_command) {
        Connection connect = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(path);
            connect.setAutoCommit(false);
            statement = connect.createStatement();
            
            String sql = sql_command;
            
            statement.executeUpdate(sql);

            statement.close();
            connect.commit();
            connect.close();

        } catch (Exception e) {
            System.out.print("Try again");
            System.exit(0);
        }
    }

    public void select_db(String path, String query) {
        Connection connect = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(path);
            connect.setAutoCommit(false);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            selectByFullName(resultSet);
            resultSet.close();
            statement.close();
            connect.close();

        } catch (Exception e) {
            System.out.print("Try again");
            System.exit(0);
        }

        System.out.println("Select work!");
    }

    public void selectByFullName(ResultSet resultSet) throws Exception {
        while (resultSet.next()) {
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");

            System.out.println(first_name + ' ' + last_name);
        }
    }

    // public void advancedSearch(String phrase) {
    //     String path = "jdbc:sqlite:applicants.db";
    //     String query = "SELECT first_name, last_name FROM applicants WHERE ;";

    //     select_db(path, query);
    // }
}