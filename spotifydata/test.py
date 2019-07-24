import pandas as pd

df = pd.DataFrame.from_csv('./album_ids.csv')


list = [0,1,2,3,4,5]

print(df.iloc[5].values.flatten().tolist(), len(df))
