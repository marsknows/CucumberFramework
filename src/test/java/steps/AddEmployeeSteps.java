package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashboardPage dash = new DashboardPage();
        click(dash.pimOption);
    }

    @When("clicks on Add Employee button")
    public void clicks_on_add_employee_button() {
        DashboardPage dash = new DashboardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters first name middle name and last name")
    public void user_enters_first_name_middle_name_and_last_name() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName,"Mar5");
        sendText(add.midName, "LA");
        sendText(add.lastName, "Kn0w5");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage add = new AddEmployeePage();
        add.employeeID.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.createLoginCheckbox);
    }

    @When("user enters username and password and confirm password")
    public void user_enters_username_and_password_and_confirm_password() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.createUsername, "IslandBoiMarz");
        sendText(add.createPassword, "Hum@nhrm123");
        sendText(add.reEnterPassword, "Hum@nhrm123");
    }
    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String midName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName,firstName);
        sendText(add.midName, midName);
        sendText(add.lastName, lastName);
    }
    @When("user enters {string} {string} and {string} for an employee")
    public void user_enters_and_for_an_employee(String firstName, String midName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName,firstName);
        sendText(add.midName, midName);
        sendText(add.lastName, lastName);
    }
    @When("I add multiple employees and verify that user has been added successfully")
    public void i_add_multiple_employees_and_verify_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String,String>> employeeNames = employees.asMaps();

        for (Map<String,String> employeeName:employeeNames) {
            String valueFirstName = employeeName.get("firstName");
            String valueMidName = employeeName.get("midName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePage add = new AddEmployeePage();
            sendText(add.firstName,valueFirstName);
            sendText(add.midName, valueMidName);
            sendText(add.lastName, valueLastName);

            click(add.saveBtn);
            //Assertion in homework
            //verify the employee has been added

            DashboardPage dash = new DashboardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);
        }
    }
    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) {
        List<Map<String,String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);

        DashboardPage dash = new DashboardPage();
        AddEmployeePage add = new AddEmployeePage();

        Iterator<Map<String,String>> it = newEmployees.iterator();
        while (it.hasNext()){
            Map<String,String> mapNewEmp = it.next();
            sendText(add.firstName, mapNewEmp.get("FirstName"));
            sendText(add.midName, mapNewEmp.get("MiddleName"));
            sendText(add.lastName, mapNewEmp.get("LastName"));
            click(add.saveBtn);
            //Assertion in HW
            click(dash.addEmployeeButton);
        }
    }
}
