import billboard
import pandas as pd

"""
Script to scrape every existing album in billboard top 200 albums.
Removes duplicates.
"""
artist = []
album_name = []

chart = billboard.ChartData('billboard-200')
while chart.previousDate:
    for i in range(len(chart)):
        artist.append(chart[i].artist)
        album_name.append(chart[i].title)
    chart = billboard.ChartData('billboard-200', chart.previousDate)

df = pd.DataFrame({"album_name": album_name, "artist": artist})
df.drop_duplicates(subset=['album_name', 'artist'], inplace=True)
grouped = df.groupby(['album_name', 'artist'], as_index=True).size()

if grouped[grouped > 1].count() != 0:
    print("uh oh")

df.to_csv('billboard-200.csv')






