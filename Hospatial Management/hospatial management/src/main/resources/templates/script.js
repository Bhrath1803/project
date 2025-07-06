document.addEventListener("DOMContentLoaded", () => {
    const links = document.querySelectorAll("nav a");

    links.forEach(link => {
        link.addEventListener("click", () => {
            console.log(`Navigating to ${link.getAttribute("href")}`);
        });
    });
});
// Validate registration form
function validateRegistration() {
    const username = document.querySelector("input[name='username']");
    const password = document.querySelector("input[name='password']");

    if (username.value.trim() === "" || password.value.trim() === "") {
        alert("Username and password are required.");
        return false;
    }

    if (password.value.length < 6) {
        alert("Password must be at least 6 characters.");
        return false;
    }

    return true;
}



// Automatically run this on contact page
document.addEventListener("DOMContentLoaded", function () {
    showMessageSent();
});document.addEventListener("DOMContentLoaded", function () {
       const successMessage = document.getElementById("Booking-success-message");

       // Check if the success message exists (Thymeleaf condition adds it)
       if (successMessage && successMessage.innerText.trim() !== "") {
           successMessage.style.display = "block";

           // Optionally hide after 5 seconds
           setTimeout(() => {
               successMessage.style.display = "none";
           }, 5000);
       }
   });document.addEventListener("DOMContentLoaded", function () {
          const form = document.querySelector("form");
          const username = document.querySelector("input[name='username']");
          const password = document.querySelector("input[name='password']");

          form.addEventListener("submit", function (e) {
              if (username.value.trim() === "" || password.value.trim() === "") {
                  e.preventDefault();
                  alert("Please fill in both Username and Password.");
              }
          });
      });
      document.addEventListener("DOMContentLoaded", function () {
          const form = document.querySelector("form");
          const successDiv = document.querySelector(".success-message");

          form.addEventListener("submit", function (e) {
              e.preventDefault(); // Stop default submit for demo

              // You can make an actual AJAX call here to submit data
              // For now, just show the message
              successDiv.style.display = "block";

              // Optional: reset form
              form.reset();

              // Optional: hide message after 3 seconds
              setTimeout(() => {
                  successDiv.style.display = "none";
              }, 3000);
          });
      });
      // Validate appointment form
      function validateAppointment() {
          const name = document.querySelector("input[name='patientName']");
          const date = document.querySelector("input[name='date']");
          const time = document.querySelector("input[name='time']");

          if (!name.value || !date.value || !time.value) {
              alert("Please fill in all appointment fields.");
              return false;
          }

          const appointmentDate = new Date(date.value);
          const today = new Date();

          if (appointmentDate < today) {
              alert("Appointment date cannot be in the past.");
              return false;
          }

          return true;
      }

      // Show message sent confirmation
      function showMessageSent() {
          const params = new URLSearchParams(window.location.search);
          if (params.has('sent')) {
              alert("Message sent successfully!");
          }
      }