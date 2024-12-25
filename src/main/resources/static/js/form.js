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
    const formData = {
            sector: document.getElementById('sector').value,
            enterprise: document.getElementById('enterprise').value,
            previewData: document.getElementById('previewData').value
            };
    // Enviar os dados ao servidor usando fetch
        fetch('/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
                throw new Error('Erro ao salvar os dados');
            })
            .then(message => {
                // Exibir mensagem de sucesso
//                alert(message);

                // Limpar os campos do formulário
                document.getElementById('deliveryForm').reset();

                // Fechar o modal
                const confirmationModal = bootstrap.Modal.getInstance(document.getElementById('confirmationModal'));
                confirmationModal.hide();
            })
            .catch(error => {
                console.error('Erro:', error);
                alert('Ocorreu um erro ao salvar a entrega.');
            });
    }
