"""
This script will iterate through a csv file containing track-ids and scrape spotify's API
by getting a list of tracks and their audio features from each track. Will then concat with track_ids into new csv file.

"""

import spotipy
from spotipy.oauth2 import SpotifyClientCredentials
import pandas as pd

# set up spotipy wrapper
client_credentials_manager = SpotifyClientCredentials(client_id="ae1c25b01ed94b4cb0b48cd1e679f051", client_secret="8a9d601440204112b46c1d3e4d0d26e4")
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

df = pd.read_csv('./track_ids.csv')
track_ids = df['track_ids']

danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, duration_ms, time_signature = [],[],[],[],[],[],[],[],[],[],[],[],[]

debug = []

i, j = 0, 20
try:
    while j < len(track_ids):
        if j + 20 > len(track_ids): # if reaching the end of the dataframe
            while i < len(track_ids):
                track = str(track_ids[i])
                debug.append(track)
                audio_features = sp.audio_features(track)
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
        
        track_list = list(map(lambda x: str(x), df['track_ids'][i:j].values.flatten().tolist()))
        debug.extend(track_list)

        audio_features = sp.audio_features(track_list)
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
except Exception as err:
    print(debug)
    print("OMGOMGOMGOMG")
    print(err)
    
data = {'danceability': danceability, 'energy': energy,
            'key': key, 'loudness': loudness, 'mode': mode, 'speechiness': speechiness, 'acousticness': acousticness,
            'instrumentalness': instrumentalness, 'liveness': liveness, 'valence': valence, 'tempo': tempo, 'duration_ms': duration_ms,
            'time_signature': time_signature}

df2 = pd.DataFrame(data)

frames = [df, df2]

pd.concat(frames, axis=1).to_csv('final.csv')



