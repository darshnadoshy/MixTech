import datetime
import pandas as pd
from spotipy.oauth2 import SpotifyClientCredentials
import spotipy
client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

#import requests as req

# response = req.get('https://www.api.spotify.com')
# print(response.status_code)
# print(response.raise_for_status())

#print(sp.album('3mvWfqa4cceoGyA7qECPWH')['name'])


# df = pd.read_csv('./album_ids.csv')
# print(df.duplicated(subset="album_ids").to_csv('duplicated_rows.csv'))


# df = pd.read_csv('./billboard-200.csv')
# print(df.duplicated(subset="album_name").to_csv('single.csv'))

#print(sp.search(q="Step On Out The Oak Ridge Boys", type="album", limit=3)['albums']['items'][0])

# df = pd.read_csv('./billboard-200.csv')

# print(df.shape)

# print(sp.album('2ACmsLwZxp7kFSWdxkl5qM')['name'])

df = pd.read_csv('./track_ids.csv')

# tracks = df['track_ids'][0:4].values.flatten().tolist()
# tracks.append(1.00)
# nums = list(map(lambda x: str(x), df['track_ids'][0:4].values.flatten().tolist()))

# print(type(nums))

print(sp.track('5P0EYQ86TF7gC2WzZXcAGz')['artists'][0]['name'])

#print(datetime.datetime.now())

# df = pd.DataFrame({'a': ['1', 4,4,4,4,4], 'b': ['2', 5,5,5,5,5], 'c': ['3', 6,6,6,6,6]})
# df2 = pd.DataFrame({'d': ['4', 7,7,7,7,7], 'e': ['5', 8,8,8,8,8], 'f': ['6', 9,9,9,9,9]})

# frames = [df, df2]

# print(type(pd.concat(frames, axis=1)))
# print(type(df))

# print(type(pd.read_csv('./album_ids.csv')))





df1 = pd.read_csv('./failed_artists.csv', dtype='str')['spotify_uri']

df2 = pd.read_csv('./failed_artists.csv', dtype='str')['artists']
frames = [df1, df2]
pd.concat(frames, axis=1).to_csv('use.csv')
#print(df2['artists'])
#artists = df['artists']

#print(df['track_ids'][27104])


