import React, { useState } from "react";

function Login() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div>
      <button onClick={() => setIsLoggedIn(true)}>Login</button>
      <button onClick={() => setIsLoggedIn(false)}>Logout</button>

      <h3>{isLoggedIn ? "Welcome User!" : "Please Login"}</h3>
    </div>
  );
}

export default Login;
