package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseInitService.initBatabase();
        DatabasePopulateService.populateDatabase();

        DatabaseQueryService dbService = new DatabaseQueryService();
        System.out.println("dbService.findLongestProjects() = " + dbService.findLongestProjects());
        System.out.println("dbService.findMaxProjectsClient() = " + dbService.findMaxProjectsClient());
        System.out.println("dbService.findMaxWorkerSalary() = " + dbService.findMaxWorkerSalary());
        System.out.println("dbService.findYoungestEldestWorkers() = " + dbService.findYoungestEldestWorkers());
        System.out.println("dbService.getProjectPrices() = " + dbService.getProjectPrices());
    }
}