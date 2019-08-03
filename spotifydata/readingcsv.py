import pandas as pd
import spotipy
from spotipy.oauth2 import SpotifyClientCredentials
import pandas as pd

client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

df = pd.read_csv('./billboard-200.csv')

# <--- row --->
# Name: 2787, dtype: object
# Unnamed: 0         32557
# album_name    Santana IV
# artist           Santana

# <--- i --->
# index number

# row[0] index
# row[1] album_name
# row[2] artist

album_ids = []
failed_albums = []

for _, row in df.iterrows():
    try:
        album_ids.append(sp.search(q=str(row[1]) + ' ' + str(row[2]), type="album", limit=3)['albums']['items'][0]['id'])
    except:
        failed_albums.append(str(row[1]) + ' ' + str(row[2]))


a = pd.DataFrame({'album_ids': album_ids})
b = pd.DataFrame({'failed_albums': failed_albums})

a.to_csv('album_ids.csv')
b.to_csv('failed_albums.csv')





