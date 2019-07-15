"""
This script will iterate through a csv file containing album names and scrape spotify's API
by getting a list of tracks and their audio features from each album. Will then save it to its own csv file.

"""

import spotipy
from spotipy.oauth2 import SpotifyClientCredentials
import pandas as pd

client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)


album_search = sp.search(q="Cuz I Love You", type="album", limit=3)
album_id = album_search['albums']['items'][0]['id']

album = sp.album(album_id)
track_ids = []
track_names = []

for track in album['tracks']['items']:
    track_ids.append(track['id'])
    track_names.append(track['name'])

audio_features = []

for id in track_ids:
    audio_features.append(sp.audio_features(id)[0])

danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, duration_ms, time_signature = [],[],[],[],[],[],[],[],[],[],[],[],[]


for feats in audio_features:
    danceability.append(feats['danceability'])
    energy.append(feats['energy'])
    key.append(feats['key'])
    loudness.append(feats['loudness'])
    mode.append(feats['mode'])
    speechiness.append(feats['speechiness'])
    acousticness.append(feats['acousticness'])
    instrumentalness.append(feats['instrumentalness'])
    liveness.append(feats['liveness'])
    valence.append(feats['valence'])
    tempo.append(feats['tempo'])
    duration_ms.append(feats['duration_ms'])
    time_signature.append(feats['time_signature'])

data = {'track_name': track_names,'track_id': track_ids, 'danceability': danceability, 'energy': energy,
        'key':key, 'loudness':loudness, 'mode':mode, 'speechiness':speechiness, 'acousticness':acousticness,
        'instrumentalness':instrumentalness, 'liveness':liveness, 'valence':valence, 'tempo':tempo, 'duration_ms':duration_ms,
        'time_signature':time_signature}
df = pd.DataFrame(data)

df.to_csv('cuziloveyou.csv')


