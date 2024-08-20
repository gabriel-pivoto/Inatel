import requests

URL = "https://www.omdbapi.com/?t=rick_and_morty&season=4&episode=8&apikey=6585022c"

def test_status_code_ok():
    response = requests.get(URL)
    assert response.status_code == 200

def test_title():
    response = requests.get(URL)
    data = response.json()
    title = data.get("Title")
    assert title == "The Vat of Acid Episode"

def test_title_negative():
    response = requests.get(URL)
    data = response.json()
    title = data.get("Title")
    assert not title == "Pilot"

def test_genre():
    response = requests.get(URL)
    data = response.json()
    genre = data.get("Genre")
    assert genre == "Animation, Adventure, Comedy"

def test_genre_negative():
    response = requests.get(URL)
    data = response.json()
    genre = data.get("Genre")
    assert not genre == "Adult"