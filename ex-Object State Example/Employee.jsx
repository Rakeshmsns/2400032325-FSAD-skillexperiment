import React, { useState } from "react";

function Employee() {
  const [employee, setEmployee] = useState({
    name: "John",
    department: "HR"
  });

  return (
    <div>
      <h2>Name: {employee.name}</h2>
      <h2>Department: {employee.department}</h2>

      <button 
        onClick={() => 
          setEmployee({ name: "Sarah", department: "IT" })
        }
      >
        Change Employee
      </button>
    </div>
  );
}

export default Employee;
