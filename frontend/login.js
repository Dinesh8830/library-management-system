 let role = "student";

  function selectRole(selectedRole) {
    role = selectedRole;

    document.getElementById("studentBtn").classList.remove("active");
    document.getElementById("adminBtn").classList.remove("active");

    if (selectedRole === "student") {
      document.getElementById("studentBtn").classList.add("active");
    } else {
      document.getElementById("adminBtn").classList.add("active");
    }
  }

  function login(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    console.log("Role:", role);
    console.log("Username:", username);
    console.log("Password:", password);

    alert("Login as " + role);

    // Example API call structure
    /*
    fetch("http://localhost:8080/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password, role })
    })
    .then(res => res.json())
    .then(data => console.log(data));
    */
  }