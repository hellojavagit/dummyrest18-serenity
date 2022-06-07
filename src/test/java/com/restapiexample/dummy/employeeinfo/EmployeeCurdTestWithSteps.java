package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import com.restapiexample.dummy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EmployeeCurdTestWithSteps extends TestBase {
    static String name = "NewlyCreatedUser" + TestUtils.getRandomValue();
    static int salary =  60000 ;
    static int age =  50;
    static int id;

    @Steps
    EmployeeSteps employeeSteps ;

    @Title("Getting All The Employees Details")
    @Test
    public void test001(){
        employeeSteps.getEmployees().statusCode(200);
    }

    @Title("Getting the Single Employee Details By Id")
    @Test
    public void test002(){
        employeeSteps.getEmployeeListById(id).statusCode(200);
    }

    @Title("Creating an Employee")
    @Test
    public void test003(){
        ValidatableResponse response = employeeSteps.createEmployee(name,salary,age,id);
        response.log().all().statusCode(201);
    }

    @Title("Updating an Employee")
    @Test
    public void test004(){
      String name = "Newlycreated-updated";
        ValidatableResponse response = employeeSteps.updateEmployee(name,salary,age,id);
        response.log().all().statusCode(200);
    }
    @Title("Deleting the Employee and verify if the Employee is deleted or not")
    @Test
    public void test005(){
        employeeSteps.deleteEmployee(id).statusCode(204);
        employeeSteps.getEmployeeListById(id).statusCode(404);
    }


    }




