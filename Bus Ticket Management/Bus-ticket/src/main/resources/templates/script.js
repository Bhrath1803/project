// Wait for DOM to load
document.addEventListener('DOMContentLoaded', function () {

    /* ===== Form Validation ===== */
    const forms = document.querySelectorAll('form.needs-validation');
    forms.forEach(form => {
        form.addEventListener('submit', function (e) {
            const inputs = form.querySelectorAll('input, select');

            let isValid = true;

            inputs.forEach(input => {
                if (input.hasAttribute('required') && input.value.trim() === '') {
                    input.classList.add('input-error');
                    isValid = false;
                } else {
                    input.classList.remove('input-error');
                }

                if (input.type === 'email' && !validateEmail(input.value)) {
                    input.classList.add('input-error');
                    isValid = false;
                }
            });

            if (!isValid) {
                e.preventDefault();
                alert('Please fill in all required fields correctly.');
            }
        });
    });

    /* ===== Delete Confirmation (Admin/User History) ===== */
    const deleteButtons = document.querySelectorAll('.btn-delete');
    deleteButtons.forEach(btn => {
        btn.addEventListener('click', function (e) {
            const confirmed = confirm('Are you sure you want to delete this record?');
            if (!confirmed) {
                e.preventDefault();
            }
        });
    });

    /* ===== Booking Confirmation ===== */
    const bookingForm = document.querySelector('#booking-form');
    if (bookingForm) {
        bookingForm.addEventListener('submit', function (e) {
            const confirmed = confirm('Confirm booking?');
            if (!confirmed) {
                e.preventDefault();
            }
        });
    }

    /* ===== Show/Hide Password Toggle ===== */
    const togglePassIcons = document.querySelectorAll('.toggle-password');
    togglePassIcons.forEach(icon => {
        icon.addEventListener('click', function () {
            const input = document.querySelector(this.getAttribute('data-target'));
            if (input.type === 'password') {
                input.type = 'text';
                this.textContent = '🙈';
            } else {
                input.type = 'password';
                this.textContent = '👁️';
            }
        });
    });

    /* ===== Auto-dismiss Alerts ===== */
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => {
            alert.style.display = 'none';
        }, 5000);
    });

});

/* ===== Utility Functions ===== */
function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}