import {React} from 'react';
import {Link} from 'react-router-dom';
import "./MatchDetailCard.css";

export const MatchDetailCard=({teamName,match}) => {
  if(!match) return null; 
  const otherTeam=(match.team1===teamName) ? match.team2 :match.team1;
    const otherTeamRoute=`/teams/${otherTeam}`;
    
  return (
    <div className="MatchDetailCard">
      <span className="vs">vs</span>
      <h1> <Link to={otherTeamRoute}>{otherTeam}</Link> </h1>
      <h2 className='match-date'>on {match.date} </h2>
      <h2 className='match-venue'>at {match.venue} </h2>
      <h3 className='winner'> Winner: {match.matchWinner} Won by {match.resultMargin} {match.result} </h3>
    

    </div>
  );
}