package ai.brace;

public class Employee
{
    public String firstName;
    public String middleInitial;
    public String lastName;
    public String socialSecurityNumber;

    public Employee(String _lastName, String _firstName, String _middleInitial, String _socialSecurityNumber)
    {
        firstName = _firstName;
        middleInitial = _middleInitial;
        lastName = _lastName;
        socialSecurityNumber = _socialSecurityNumber;
    }

    public int hashCode()
    {
        String no_dashes = socialSecurityNumber.replace("-", "");
        return Integer.parseInt(no_dashes);
    }


    public boolean equals(Object obj) {
        if(this == obj)
        {
            return true;
        }
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        Employee comparison_employee = (Employee) obj;
        if(this.hashCode() == comparison_employee.hashCode())
        {
            return true;
        } else
        {
            return false;
        }
    }
}
