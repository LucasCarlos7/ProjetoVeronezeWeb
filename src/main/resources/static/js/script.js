function obterProximoId() {
    fetch('/nextId') // Chama a rota para obter o próximo ID do backend
        .then(response => response.json())
        .then(data => {
            document.getElementById('nextId').textContent = data; // Exibe o próximo ID na página
        })
        .catch(error => console.error('Erro:', error));
}

document.addEventListener('DOMContentLoaded', obterProximoId);

