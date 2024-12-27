function openConfirmationModal() {
    const sector = document.getElementById('sector').value;
    const enterprise = document.getElementById('enterprise').value;
    const recipientName = document.getElementById('recipientName').value;
    const deliveryCode = document.getElementById('deliveryCode').value;
    const previewData = document.getElementById('previewData').value;

    document.getElementById('confirmSector').textContent = sector;
    document.getElementById('confirmEnterprise').textContent = enterprise;
    document.getElementById('confirmRecipientName').textContent = recipientName;
    document.getElementById('confirmDeliveryCode').textContent = deliveryCode;
    document.getElementById('confirmPreviewData').textContent = previewData;

    const confirmationModal = new bootstrap.Modal(document.getElementById('confirmationModal'));
    confirmationModal.show();
}

function submitForm() {
    const formData = {
        sector: document.getElementById('sector').value,
        enterprise: document.getElementById('enterprise').value,
        recipientName: document.getElementById('recipientName').value,
        deliveryCode: document.getElementById('deliveryCode').value,
        previewData: document.getElementById('previewData').value
    };

    fetch('/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(errors => {
                    throw errors;
                });
            }
            return response.text();
        })
        .then(() => {
            document.getElementById('deliveryForm').reset();
            const confirmationModal = bootstrap.Modal.getInstance(document.getElementById('confirmationModal'));
            confirmationModal.hide();
        })
        .catch(errors => {
            if (typeof errors === 'object') {
                const errorList = document.getElementById('errorList');
                errorList.innerHTML = ''; // Limpar erros anteriores
                Object.entries(errors).forEach(([field, message]) => {
                    const li = document.createElement('li');
                    li.textContent = `${field}: ${message}`;
                    errorList.appendChild(li);
                });

                const errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
                errorModal.show();
            } else {
                console.error('Erro inesperado:', errors);
            }
        });
}
