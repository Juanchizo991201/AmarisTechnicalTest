import { useState } from "react";

import { getEmployeeById, getEmployees } from "@/services/employee";
import type { Employee } from "@/types/employee";

export const useEmployeeList = () => {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [employeeId, setEmployeeId] = useState<number>();
  const [fetchError, setFetchError] = useState<boolean>(false);

  const handleSearch = async () => {
    try {
      if (employeeId && employeeId > 0) {
        const data = await getEmployeeById(employeeId);

        setEmployees([data]);

        return;
      }

      const data = await getEmployees();

      setEmployees(data);
    } catch (e) {
      setFetchError(true);

      setTimeout(() => {
        setFetchError(false);
      }, 5000);
    }
  };

  return {
    fetchError,
    employees,
    employeeId,
    setEmployeeId,
    handleSearch,
  };
};
