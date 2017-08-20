import React from 'react';
import DrinkList from "./DrinkList.jsx";
import MixedDrink from "./MixedDrink.jsx";
import SearchBar from "./SearchBar.jsx"
import Grid from 'material-ui/Grid';
import Typography from 'material-ui/Typography'


export default class App extends React.Component {
    render() {
        //<div style={{textAlign: 'center'}}>
        var thingsThatGetYouLit = ['vodka', 'orange juice', 'cranberry juice'];
        
        return (
            <div>
                <h1>LitBit</h1>
                <Grid container="true">
                    <SearchBar ingredients={thingsThatGetYouLit}/>
                    <DrinkList ingredients={thingsThatGetYouLit}/>
                    <MixedDrink ingredients={thingsThatGetYouLit}/>
                </Grid>
            </div>
        );
    }
}