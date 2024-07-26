import type { Employee } from "@/types/employee";

const API_BASE_URL = import.meta.env.VITE_API_URL;

export const getEmployees = async () => {
  console.log({ API_BASE_URL });

  const response = await fetch(`${API_BASE_URL}/employee`);

  console.log({ response });

  if (!response.ok) {
    throw new Error("Failed to fetch employee. Please try again later.");
  }

  const data: Employee[] = await response.json();
  return data;
};

export const getEmployeeById = async (id: number): Promise<Employee> => {
  console.log({ API_BASE_URL });

  const response = await fetch(`${API_BASE_URL}/employee/${id}`);
  console.log({ response });

  if (!response.ok) {
    throw new Error("Failed to fetch employee. Please try again later.");
  }

  const data: Employee = await response.json();
  return data;
};
