// Función principal para cifrar el texto de entrada
function encryptText() {
    var inputText = document.getElementById('inputText').value;

    // Validación de entrada: solo letras minúsculas y asegurarse de que no esté vacío
    if (!validateInput(inputText)) {
        if (inputText.trim() === '') {
            alert('No has ingresado ninguna palabra. Por favor, ingresa una palabra para cifrar/descifrar.');
        } else {
            alert('Por favor, ingresa solo letras minúsculas y sin caracteres especiales.');
        }
        return;
    }

    // Obtener el elemento de salida y establecer el texto cifrado
    var outputText = document.getElementById('outputText');
    outputText.value = encrypt(inputText);
}

// Función principal para descifrar el texto de entrada
function decryptText() {
    var inputText = document.getElementById('inputText').value;

    // Validación de entrada: solo letras minúsculas y asegurarse de que no esté vacío
    if (!validateInput(inputText)) {
        if (inputText.trim() === '') {
            alert('No has ingresado ninguna palabra. Por favor, ingresa una palabra para cifrar/descifrar.');
        } else {
            alert('Por favor, ingresa solo letras minúsculas y sin caracteres especiales.');
        }
        return;
    }

    // Obtener el elemento de salida y establecer el texto descifrado
    var outputText = document.getElementById('outputText');
    outputText.value = decrypt(inputText);
}

// Función para validar la entrada y asegurarse de que solo contiene letras minúsculas
function validateInput(text) {
    var regex = /^[a-z\s]+$/;
    return regex.test(text);
}

// Función para cifrar el texto según las reglas dadas
function encrypt(text) {
    return text.replace(/e/g, 'enter')
               .replace(/i/g, 'imes')
               .replace(/a/g, 'ai')
               .replace(/o/g, 'ober')
               .replace(/u/g, 'ufat');
}

// Función para descifrar el texto según las reglas dadas
function decrypt(text) {
    return text.replace(/enter/g, 'e')
               .replace(/imes/g, 'i')
               .replace(/ai/g, 'a')
               .replace(/ober/g, 'o')
               .replace(/ufat/g, 'u');
}

// Función para limpiar los campos de entrada y salida
function clearText() {
    document.getElementById('inputText').value = '';
    document.getElementById('outputText').value = '';
}

// Función para copiar el texto cifrado/descifrado al portapapeles
function copyToClipboard() {
    var outputText = document.getElementById('outputText');
    outputText.select();
    document.execCommand('copy');
}