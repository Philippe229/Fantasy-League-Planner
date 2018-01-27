from urllib2 import Request, urlopen
import json
from pandas.io.json import json_normalize

data = []
for teamId in range(1, 31):
    # get all 31 teams
    req = Request('http://conu.astuce.media:9993/api/sports/hockey/teams?Id='+str(teamId))
    res = urlopen(req)
    elevations = res.read()
    # data is of type list
    data.append(json.loads(elevations))
    # get all players for team
    req = Request('http://conu.astuce.media:9993/api/sports/hockey/team/persons?TeamId='+str(teamId))
    res = urlopen(req)
    elevations = res.read()
    data[teamId-1].append(json.loads(elevations))

with open('teams_players.json', 'w') as outfile:
    json.dump(data, outfile)
    
# print(json_normalize(data['results']))
