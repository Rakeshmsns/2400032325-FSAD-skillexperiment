import React, { useState } from "react";

function Toggle() {
  const [show, setShow] = useState(false);

  return (
    <div>
      <button onClick={() => setShow(!show)}>Toggle</button>

      {show && <p>Hello, Welcome!</p>}
    </div>
  );
}

export default Toggle;
