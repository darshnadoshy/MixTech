import datetime
import pandas as pd
from spotipy.oauth2 import SpotifyClientCredentials
import spotipy
client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

df = pd.read_csv('./hopefully3.csv')['artists']
df2 = pd.read_csv('./hopefully2.csv')['artists']

frames = [df, df2]

pd.concat(frames, axis=0).to_csv('hopefully4.csv')

# df.rename(columns={'Chris Brown': 'artists'}).to_csv('hopefully3.csv')

# df = pd.read_csv('./hopefully2.csv')

# track_ids = df['spotify_uri']
# track_ids2 = pd.read_csv('./final.csv')['spotify_uri'][204570]
# print(track_ids2)
# print(track_ids[204570])



# print(sp.track('5IgMfw0JVZEPHLNUALQvMQ')['artists'][0]['name'])


