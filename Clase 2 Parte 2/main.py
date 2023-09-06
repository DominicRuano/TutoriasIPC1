def analizador (k,A):

    lista = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"]
    temporal = k

    while (True):
        for x in range(0,7):
            temporal -= A[x]
            if (temporal <= 0):             
                return(lista[x])
                

print(analizador(7823, [8, 16, 63, 11, 83, 46, 28]))
    