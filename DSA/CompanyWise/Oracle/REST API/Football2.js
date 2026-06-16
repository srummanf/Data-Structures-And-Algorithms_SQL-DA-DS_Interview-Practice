/** In this challenge, the REST API contains information about football
matches. The provided API allows querying matches by teams and
year. Your task is to get the total number of goals scored by a
given team in a given year.
To access a collection of matches, perform GET requests to
https://jsonmock.hackerrank.com/api/football_matches?year=
<year>&team I =<team>&page=<page>
https://jsonmock.hackerrank.com/api/football_matches?year=
<year>&team2=<team>&page=<page>
where <year> is the year of the competition, <team> is the name
of the team, and <page> is the page of the results to request. The
results might be divided into several pages. Pages are numbered
from 1.

Sample Input For Custom Testing
Barcelona
2011
Sample Output
35

*/

const fetch = require('node-fetch');

async function getTotalGoals(team, year) {
    let totalGoals = 0;

    try {
        // Fetch goals for matches where the team is the home team (team1)
        totalGoals += await fetchGoals(`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team1=${team}`, team);

        // Fetch goals for matches where the team is the away team (team2)
        totalGoals += await fetchGoals(`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team2=${team}`, team);
    } catch (error) {
        console.error("Error fetching goals:", error);
    }

    return totalGoals;
}

async function fetchGoals(url, team) {
    let goals = 0;
    let page = 1;

    while (true) {
        try {
            const response = await fetch(`${url}&page=${page}`);
            // const response = await axios.get(`${url}&page=${page}`);
            const data = await response.json();
            // const data = response.data;

            data.data.forEach(match => {
                if (url.includes('team1') && match.team1 === team) {
                    goals += parseInt(match.team1goals);
                } else if (url.includes('team2') && match.team2 === team) {
                    goals += parseInt(match.team2goals);
                }
            });

            // data.data.forEach(match ==>{
            //     const team1 = parseString(match.team1);
            //     const team2 = parseString(match.team2);
            //     if(team1==team) goals += parseInt(match.team1goals);
            //     if(team2==team) goals += parseInt(match.team2goals);
            // })

            if (page >= data.total_pages) {
                break;
            }

            page++;
        } catch (error) {
            console.error(`Error fetching page ${page}:`, error);
            break;
        }
    }

    return goals;
}

// Example usage
getTotalGoals('Barcelona', 2011).then(totalGoals => {
    console.log(`Total goals scored by Barcelona in 2011: ${totalGoals}`);
}).catch(error => {
    console.error("Error:", error);
});
