"""
This script will iterate through a csv file containing album names and scrape spotify's API
by getting a list of tracks and their audio features from each album. Will then save it to its own csv file.

"""

import spotipy
from spotipy.oauth2 import SpotifyClientCredentials
import pandas as pd

# set up spotipy wrapper
client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

df = pd.read_csv('./album_ids.csv')
album_ids = df['album_ids']

track_ids = [] # track ids to search
track_names = [] # track name for outputted dataframe
danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, duration_ms, time_signature = [],[],[],[],[],[],[],[],[],[],[],[],[]


i, j = 0, 20
try:
    while j < len(album_ids):
        if j + 20 > len(album_ids): # if reaching the end of the dataframe
            while i < len(album_ids):
                # do stuff
                album = sp.album(album_ids[i])
                album_tracks = []
                for track in album['tracks']['items']:
                    track_ids.append(track['id'])
                    album_tracks.append(track['id'])
                    track_names.append(track['name'])
                audio_features = sp.audio_features(album_tracks)
                for feats in audio_features:
                    if feats is None:
                        danceability.append(None)
                        energy.append(None)
                        key.append(None)
                        loudness.append(None)
                        mode.append(None)
                        speechiness.append(None)
                        acousticness.append(None)
                        instrumentalness.append(None)
                        liveness.append(None)
                        valence.append(None)
                        tempo.append(None)
                        duration_ms.append(None)
                        time_signature.append(None)
                        continue
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
                
                i += 1
            break
        
        albums = sp.albums(album_ids[i:j].values.flatten().tolist())
        for album in albums['albums']:
            album_tracks = []
            for track in album['tracks']['items']:
                track_ids.append(track['id'])
                album_tracks.append(track['id'])
                track_names.append(track['name'])
            audio_features = sp.audio_features(album_tracks)
            for feats in audio_features:
                if feats is None:
                    danceability.append(None)
                    energy.append(None)
                    key.append(None)
                    loudness.append(None)
                    mode.append(None)
                    speechiness.append(None)
                    acousticness.append(None)
                    instrumentalness.append(None)
                    liveness.append(None)
                    valence.append(None)
                    tempo.append(None)
                    duration_ms.append(None)
                    time_signature.append(None)
                    continue
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
        i = j
        j += 20
except spotipy.client.SpotifyException as err:
    print(err)
    
data = {'track_name': track_names,'track_id': track_ids, 'danceability': danceability, 'energy': energy,
            'key':key, 'loudness':loudness, 'mode':mode, 'speechiness':speechiness, 'acousticness':acousticness,
            'instrumentalness':instrumentalness, 'liveness':liveness, 'valence':valence, 'tempo':tempo, 'duration_ms':duration_ms,
            'time_signature':time_signature}
df = pd.DataFrame(data)

df.to_csv('audio_features.csv')



