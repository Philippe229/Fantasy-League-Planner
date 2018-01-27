from urllib2 import Request, urlopen
import json
import requests
import numpy as np
from pandas.io.json import json_normalize
from pandas import read_csv


teams = read_csv('http://conu.astuce.media:9993/api/sports/hockey/teams?format=csv&Id='+str(1))
players = read_csv('http://conu.astuce.media:9993/api/sports/hockey/team/persons?format=csv&TeamId='+str(1))
for teamId in range(2, 31):
    teams = teams.append(read_csv('http://conu.astuce.media:9993/api/sports/hockey/teams?format=csv&Id='+str(teamId)))
    players = players.append(read_csv('http://conu.astuce.media:9993/api/sports/hockey/team/persons?format=csv&TeamId='+str(teamId)))
print(teams.head())
print(players.head())


# data = []
# for teamId in range(1, 2):
    # get all 31 teams
    # req = Request('http://conu.astuce.media:9993/api/sports/hockey/teams?Id='+str(teamId))
    # res = urlopen(req)
    # elevations = res.read()
    # data is of type list
    # data.append(json.loads(elevations))
    # get all players for team
    # req = Request('http://conu.astuce.media:9993/api/sports/hockey/team/persons?TeamId='+str(teamId))
    # res = urlopen(req)
    # elevations = res.read()
    # data[teamId-1].append(json.loads(elevations))

# with open('teams_players.json', 'w') as outfile:
#     json.dump(data, outfile)
#
# print(json_normalize(data['results']))
