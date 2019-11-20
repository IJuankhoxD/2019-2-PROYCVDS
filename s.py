import random as r

ubicacion = ["edificio F", "edificio H", "edificio B", "edificio A","edificio C"]
tipo_r = ["computador","sala de estudio","libro"]


for i in range(0,20):
    s = "INSERT INTO recurso(id,disponible,averiado,ubicacion,nombre,capacidad,tipo_recurso) VALUES "
    r1 = r.randint(101,117)
    r2 = r.randint(1,17)
    r3 = r.randint(1,5)
    
    s += "("+str(r1)+","+str(r.choice([True, False]))+","+str(r.choice([True, False]))+",'"+r.choice(ubicacion)+"','"
    tipo= r.choice(tipo_r)
    if(tipo == "computador"):
        s+="PC"+str(r1)+"',"+r.choice(["0","1"])+",'"+tipo+"');\n"
    elif(tipo == "sala de estudio"):
        s+="SALA"+str(r2)+"',"+r.choice(["0","1"])+",'"+tipo+"');\n"        
    elif(tipo == "libro"):
        s+="Ejemplar"+str(r3)+"',"+r.choice(["0","1"])+",'"+tipo+"');\n"

    print(s)
