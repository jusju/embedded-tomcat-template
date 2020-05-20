package demo;

import java.util.Map;

public class EnvironmentVariableMapExample {

    public static void main(String[] args) {
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println(javaHome);

        Map<String, String> variables = System.getenv();

        String jdbcUrl = variables.getOrDefault("JDBC_DATABASE_URL", "jdbc:sqlite:C:\\sqlite\\Chinook_Sqlite.sqlite");
    }
}
