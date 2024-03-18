import threading
import time
from pymongo import MongoClient
from random import shuffle

client = MongoClient("mongodb://localhost:27017")

db = client["bancoiot"]
sensor = db.sensores

def temperature(intervalo):
    alarme1 = False
    alarme2 = False
    alarme3 = False
    while True:
        if not alarme1:
            temp1 = generate_temperature()
            print("Temperatura 1:", temp1)
            if not alarme1 and temp1 > 38:
                update_temperature_db("Sensor 1", temp1)
                alarme1 = True
                print('Atenção! Temperatura muito alta! Verificar Sensor 1!')
        else:
            print('Atenção! Temperatura muito alta! Verificar Sensor 1!')
        
        if not alarme2:
            temp2 = generate_temperature()
            print("Temperatura 2:", temp2)
            if not alarme2 and temp2 > 38:
                update_temperature_db("Sensor 2", temp2)
                alarme2 = True
                print('Atenção! Temperatura muito alta! Verificar Sensor 2!')
        else:
            print('Atenção! Temperatura muito alta! Verificar Sensor 2!')
        
        if not alarme3:
            temp3 = generate_temperature()
            print("Temperatura 3:", temp3)
            if not alarme3 and temp3 > 38:
                update_temperature_db("Sensor 3", temp3)
                alarme3 = True
                print('Atenção! Temperatura muito alta! Verificar Sensor 3!')
        else:
            print('Atenção! Temperatura muito alta! Verificar Sensor 3!')

        time.sleep(intervalo)

def generate_temperature():
    sequence = [i for i in range(30, 41)]
    shuffle(sequence)
    return sequence[1]

def insert_temperature_db(SensorName, sensorValue):
    sensor_alarmado = sensorValue > 38
    result = sensor.insert_one({
        'nomeSensor': SensorName,
        'valorSensor': sensorValue,
        'unidadeMedida': 'C°',
        'sensorAlarmado': sensor_alarmado
    })

    if result.acknowledged:
        print("Documento Adicionado!")

def update_temperature_db(SensorName, sensorValue):
    sensor_alarmado = sensorValue > 38
    result = sensor.update_one(
        {'nomeSensor': SensorName},
        {'$set': {'valorSensor': sensorValue, 'sensorAlarmado': sensor_alarmado}}
    )

    if result.modified_count > 0:
        print("Documento Atualizado!")
    elif result.matched_count == 0:
        print("Nenhum documento encontrado para atualizar!")

x = threading.Thread(target=temperature, args=(2,))
x.start()
