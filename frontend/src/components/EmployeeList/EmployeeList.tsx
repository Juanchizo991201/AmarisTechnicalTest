import Table from "react-bootstrap/Table";

import { EmployeeSearch } from "@/components";
import { useEmployeeList } from "./useEmployeeList";

import styles from "./EmployeeList.module.css";

export const EmployeeList = () => {
  const { employees, employeeId, handleSearch, setEmployeeId, fetchError } =
    useEmployeeList();

  return (
    <div className={styles.employeeListContainer}>
      <EmployeeSearch
        handleSearch={handleSearch}
        setEmployeeId={setEmployeeId}
        employeeId={employeeId}
        error={fetchError}
      />
      {fetchError && (
        <div className={styles.errorMessage}>
          Error fetching employees. Please try again later
        </div>
      )}
      {employees.length > 0 && (
        <Table
          striped
          bordered
          hover
          variant="light"
        >
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Salary</th>
              <th>Annual Salary</th>
              <th>Age</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.employee_name}</td>
                <td>{employee.employee_salary}</td>
                <td>{employee.employee_annual_salary}</td>
                <td>{employee.employee_age}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      )}
    </div>
  );
};
