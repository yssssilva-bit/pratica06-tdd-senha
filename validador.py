def validar_senha(senha: str) -> dict:
    erros = []
    
    if len(senha) < 8:
        erros.append("A senha deve ter pelo menos 8 caracteres")

        digitos = sum(1 for c in senha if c.isdigit())
        if digitos < 2:
            erros.append("A senha deve conter pelo menos 2 digitos")

        if not any(c.isupper() for c in senha):
            erros.append("A senha deve conter pelo menos uma letra maiuscula")

        if not any(not c.isalnum() for c in senha):
            erros.append("A senha deve conter pelo menos um caractere especial")
        
        valida = len(erros) == 0

        return {
            "valida": valida,
            "erros": erros if not valida else []
        }