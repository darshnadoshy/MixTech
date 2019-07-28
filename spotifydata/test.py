import pandas as pd
from spotipy.oauth2 import SpotifyClientCredentials
import spotipy
client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

import requests as req

# response = req.get('https://www.api.spotify.com')
# print(response.status_code)
# print(response.raise_for_status())

try:
    response = req.get('https://httpstat.us/429')
    # If the response was successful, no Exception will be raised
    response.raise_for_status()
except req.HTTPError as e:
    print(e.response.headers)


