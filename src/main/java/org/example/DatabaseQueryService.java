package org.example;

import org.example.db.Database;
import org.example.dto.*;
import org.example.utils.SqlFileLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private static final Connection DB_CONN = Database.getInstance().getConnection();

    public List<LongestProject> findLongestProjects() {
        System.out.println("Find longest projects...");
        List<LongestProject> longestProjectList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_longest_project.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LongestProject longestProject = new LongestProject(rs.getString("name"),
                        rs.getInt("month_count"));
                longestProjectList.add(longestProject);
                System.out.println(longestProject);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return longestProjectList;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        System.out.println("Find max projects client...");
        List<MaxProjectCountClient> maxProjectsList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_max_projects_client.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(rs.getString("name"),
                        rs.getInt("project_count"));
                maxProjectsList.add(maxProjectCountClient);
                System.out.println(maxProjectCountClient);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return maxProjectsList;
    }

    public List<MaxWorkerSalary> findMaxWorkerSalary() {
        System.out.println("Find max workers salary...");
        List<MaxWorkerSalary> maxWorkersSalaryList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_max_salary_worker.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MaxWorkerSalary maxWorkerSalary = new MaxWorkerSalary(rs.getString("name"),
                        rs.getInt("salary"));
                maxWorkersSalaryList.add(maxWorkerSalary);
                System.out.println(maxWorkerSalary);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return maxWorkersSalaryList;
    }

    public List<WorkerBirthday> findYoungestEldestWorkers() {
        System.out.println("Find youngest-eldest workers...");
        List<WorkerBirthday> yeWorkersList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_youngest_eldest_workers.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                WorkerBirthday yeWorker = new WorkerBirthday(
                        rs.getString("type"),
                        rs.getString("name"),
                        LocalDate.parse(rs.getString("birthday")));
                yeWorkersList.add(yeWorker);
                System.out.println(yeWorker);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return yeWorkersList;
    }

    public List<ProjectPrice> getProjectPrices() {
        System.out.println("Get project prices...");
        List<ProjectPrice> projectPricesList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/print_project_prices.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProjectPrice projectPrice = new ProjectPrice(rs.getString("name"),
                        rs.getInt("price"));
                projectPricesList.add(projectPrice);
                System.out.println(projectPrice);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return projectPricesList;
    }

}