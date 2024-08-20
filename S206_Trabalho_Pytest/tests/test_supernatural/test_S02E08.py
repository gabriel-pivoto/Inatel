import requests

URL = "https://www.omdbapi.com/?t=supernatural&season=2&episode=08&apikey=6585022c"


def test_status_code_ok():
    response = requests.get(URL)
    assert response.status_code == 200

def test_title():
    response = requests.get(URL)
    data = response.json()
    title = data.get("Title")
    assert title == "Crossroad Blues"

def test_title_negative():
    response = requests.get(URL)
    data = response.json()
    title = data.get("Title")
    assert not title == "Scoobynatural"

def test_runtime():
    response = requests.get(URL)
    data = response.json()
    runtime = data.get("Runtime")
    assert runtime == "42 min"

def test_runtime_negative():
    response = requests.get(URL)
    data = response.json()
    runtime = data.get("Runtime")
    assert not runtime == "40 min"