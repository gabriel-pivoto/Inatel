from cassandra.cluster import Cluster
from cassandra.auth import PlainTextAuthProvider
import json

# This secure connect bundle is autogenerated when you download your SCB, 
# if yours is different update the file name below
cloud_config= {
  'secure_connect_bundle': 'secure-connect-dbiot.zip'
}

# This token JSON file is autogenerated when you download your token, 
# if yours is different update the file name below
with open("dbiot-token.json") as f:
    secrets = json.load(f)

CLIENT_ID = secrets["clientId"]
CLIENT_SECRET = secrets["secret"]

auth_provider = PlainTextAuthProvider(CLIENT_ID, CLIENT_SECRET)
cluster = Cluster(cloud=cloud_config, auth_provider=auth_provider)
session = cluster.connect()


def consultar_estoque(carro):
    query = "SELECT nome, estante, quantidade FROM ksiot.estoque WHERE carro = %s ALLOW FILTERING"
    
    rows = session.execute(query, [carro])

    print("Resultados da consulta para o carro '{}':".format(carro))
    for row in rows:
        print("Nome: {}, Estante: {}, Quantidade: {}".format(row.nome, row.estante, row.quantidade))

carro = input("Digite o nome do carro para consultar o estoque: ")
consultar_estoque(carro)

session.shutdown()
cluster.shutdown()