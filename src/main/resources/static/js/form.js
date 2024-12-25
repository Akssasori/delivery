function openConfirmationModal() {
    // Capturar valores do formulário
    const sector = document.getElementById('sector').value;
    const enterprise = document.getElementById('enterprise').value;
    const previewData = document.getElementById('previewData').value;

    // Preencher os campos no modal
    document.getElementById('confirmSector').textContent = sector;
    document.getElementById('confirmEnterprise').textContent = enterprise;
    document.getElementById('confirmPreviewData').textContent = previewData;

    // Abrir o modal
    const confirmationModal = new bootstrap.Modal(document.getElementById('confirmationModal'));
    confirmationModal.show();
}

function submitForm() {
    // Submeter o formulário
    document.getElementById('deliveryForm').submit();
}
