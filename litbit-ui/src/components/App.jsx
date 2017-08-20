import React from 'react';
import DrinkList from "./DrinkList.jsx";
import MixedDrink from "./MixedDrink.jsx";
import SearchBar from "./SearchBar.jsx"
import Grid from 'material-ui/Grid';
import Typography from 'material-ui/Typography'


export default class App extends React.Component {
    render() {
        //<div style={{textAlign: 'center'}}>
        return (
            <div>
                <h1>LitBit</h1>
                <Grid container="true">
                    <SearchBar/>
                    <DrinkList/>
                    <MixedDrink/>
                </Grid>
            </div>
        );
    }
}