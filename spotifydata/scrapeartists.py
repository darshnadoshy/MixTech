import datetime
import spotipy
from spotipy.oauth2 import SpotifyClientCredentials
import pandas as pd

# set up spotipy wrapper
client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

df = pd.read_csv('./final.csv')
track_ids = df['spotify_uri']
artists = []

print(datetime.datetime.now())

for i in range(204570, len(track_ids)):
    try:
        a = sp.track(track_ids[i])['artists'][0]['name']
        if a is None: artists.append(None)
        else: artists.append(str(a))
    except Exception as e:
        print(e)
        data = {'artists': artists}
        df2 = pd.DataFrame(data)
        frames = [df, df2]
        pd.concat(frames, axis=1).to_csv('hopefully2.csv')



data = {'artists': artists}
df2 = pd.DataFrame(data)

frames = [df, df2]
pd.concat(frames, axis=1).to_csv('hopefully2.csv')

print(datetime.datetime.now())