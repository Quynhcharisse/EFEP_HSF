document.addEventListener("DOMContentLoaded", function() {
    let toastData = document.getElementById('toastData');
    if (toastData) {
        showToast();
    }
});

function showToast() {
    let toastError = document.getElementById('toastError')
    let toastMsg = '<i class="fa-solid fa-circle-xmark"></i>' + toastData.innerHTML;

    let toast = document.createElement('div');
    toast.classList.add('toast');
    toast.innerHTML = toastMsg;
    toastError.appendChild(toast);

    setTimeout(
        () => {
            toast.remove();
        }, 5600
    );
}