def saludar():
    print("¡Hola, mundo!")


saludar()  # Llama a la función saludar


def saludar_1(nombre="parametro"):
    print("¡Hola,", nombre, "!")
    print(f"¡Hola, {nombre} !")


saludar_1("Juan")  # Llama a la función saludar con el parámetro "Juan"


def suma(a, b):
    resultado = a + b
    if resultado > 6:
        print("")
    return resultado, True


resultado_suma, _ = suma(3, 4)
# Imprime "Resultado de la suma: 7"
print("Resultado de la suma:", resultado_suma)
