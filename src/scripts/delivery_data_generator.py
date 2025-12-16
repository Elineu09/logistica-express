import random
import os 

FILE_PATH = "data/delivery_data.txt"

# Capacidade do camião 
MIN_CAPACITY = 500
MAX_CAPACITY = 2000

# Número de pacotes
MIN_PACKAGES = 100
MAX_PACKAGES = 200

# Peso e valor dos pacotes
MIN_WEIGHT = 1
MAX_WEIGHT = 100

MIN_VALUE = 10
MAX_VALUE = 5000

capacity = random.randint(MIN_CAPACITY, MAX_CAPACITY)

num_packages = random.randint(MIN_PACKAGES, MAX_PACKAGES)

print(f"Gerando ficheiro delivery_data: Capacidade máxima do camião: {capacity}KG | {num_packages} pacotes...")

with open(FILE_PATH, "w", encoding="utf-8") as file:
    file.write(f"{capacity}\n")

    for _ in range(num_packages):
        weight = random.randint(MIN_WEIGHT, MAX_WEIGHT)
        value = random.randint(MIN_VALUE, MAX_VALUE)

        file.write(f"{weight},{value}\n")

print("Ficheiro gerado com sucesso!")