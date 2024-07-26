import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";

import styles from "./EmployeeSearch.module.css";

interface Props {
  handleSearch: () => void;
  setEmployeeId: (id: number) => void;
  employeeId?: number;
  error?: boolean;
}

export const EmployeeSearch: React.FC<Props> = ({
  handleSearch,
  setEmployeeId,
  employeeId,
  error,
}) => {
  return (
    <div className={styles.employeeSearchContainer}>
      <div className={styles.searchBar}>
        <Form>
          <InputGroup className={error ? styles.error : ""}>
            <InputGroup.Text>#</InputGroup.Text>
            <Form.Control
              type="number"
              min={1}
              placeholder="Enter employee ID"
              onChange={(e) => {
                setEmployeeId(Number(e.target.value));
              }}
            />
          </InputGroup>
        </Form>
        <Button
          variant="primary"
          onClick={handleSearch}
        >
          {employeeId ? "Search" : "Search All"}
        </Button>
      </div>
    </div>
  );
};
