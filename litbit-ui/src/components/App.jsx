import React from 'react';
import DrinkList from "./DrinkList.jsx";
import MixedDrink from "./MixedDrink.jsx";
import SearchBar from "./SearchBar.jsx"
import Grid from 'material-ui/Grid';


export default class App extends React.Component {
    render() {
        //<div style={{textAlign: 'center'}}>
        return (
            <div>
                <Grid container="true">
                    <DrinkList/>
                    <MixedDrink/>
                </Grid>
            </div>
        );
    }
}