from pandas import read_csv


teams = read_csv('http://conu.astuce.media:9993/api/sports/hockey/teams?format=csv&Id='+str(1))
players = read_csv('http://conu.astuce.media:9993/api/sports/hockey/team/persons?format=csv&TeamId='+str(1))
for teamId in range(2, 31):
    teams = teams.append(read_csv('http://conu.astuce.media:9993/api/sports/hockey/teams?format=csv&Id='+str(teamId)))
    players = players.append(read_csv('http://conu.astuce.media:9993/api/sports/hockey/team/persons?format=csv&TeamId='+str(teamId)))

print(teams.head())
print(players.head())

