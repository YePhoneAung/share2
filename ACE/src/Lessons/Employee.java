package Lessons;

import lombok.Getter;

@Getter
public class Employee {

    private int empId;
    private String name;
  @Override
  public String toString() {
    return "Employee [empId=" + empId + ", name=" + name + "]";
  }
    
    
    
    }
